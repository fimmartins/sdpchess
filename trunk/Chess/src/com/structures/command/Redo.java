package com.structures.command;

import com.application.GamePanel;
import com.structures.Board;
import com.structures.Game;
import com.structures.observer.Subject;

public class Redo implements Task{

	private GamePanel gp=GamePanel.getGamePanel();
	private Board board=Board.getBoard();
	private Game game=Game.getGame();
	private Subject updateGame=Subject.getSubject();

	private UndoHistoryBoard undoHistory=UndoHistoryBoard.getHistoryBoard();
	private RedoHistoryBoard redoHistory=RedoHistoryBoard.getHistoryBoard();


	public void performTask()
	{
		if(redoHistory.getLast()!=null)
		{
			undoHistory.addBoard(new HistoryEntry(game.getPlayerTurn(),board.getConfiguration(),redoHistory.getLast().getOldPosition(),redoHistory.getLast().getNewPosition()));
			
			board.setBoard(redoHistory.getLast().getConfigBoard());
			game.setPlayerTurn(redoHistory.getLast().getPlayerTurn());
			gp.resetPiecesOnBoard();
			redoHistory.removeLast();
			updateGame.notifyAllObservers();
		}
	}

}
