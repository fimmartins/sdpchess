package com.structures.command;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.application.GamePanel;
import com.structures.Board;
import com.structures.Game;
import com.structures.memento.*;
import com.structures.observer.Subject;
public class Load implements Task{
	private GamePanel gp=GamePanel.getGamePanel();
	private Board board=Board.getBoard();
	private Game game=Game.getGame();
	private Subject updateGame=Subject.getSubject();

	public void performTask() {
	
		///Deserializare
		try {
			ObjectInputStream in =new ObjectInputStream( new FileInputStream("saves.out"));
			@SuppressWarnings("unused")
			String s = (String)in.readObject();
			MementoTable table = (MementoTable)in.readObject();
			
			Originator orig=new Originator(null);
			Memento toRestore=table.getMemento("mem1");
			orig.setMemento(toRestore);
			
			board.setBoard(orig.getSave().getConfigBoard());
			game.setPlayerTurn(orig.getSave().getPlayerTurn());
			gp.resetPiecesOnBoard();
			updateGame.notifyAllObservers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
