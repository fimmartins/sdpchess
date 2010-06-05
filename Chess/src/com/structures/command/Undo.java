package com.structures.command;

import com.application.GamePanel;
import com.structures.Board;
import com.structures.Game;
import com.structures.observer.Subject;

public class Undo implements Task{
	
private GamePanel gp=GamePanel.getGamePanel();
private Board board=Board.getBoard();
private Game game=Game.getGame();
private Subject updateGame=Subject.getSubject();

private UndoHistoryBoard undoHistory=UndoHistoryBoard.getHistoryBoard();
private RedoHistoryBoard redoHistory=RedoHistoryBoard.getHistoryBoard();


	public void performTask()
	{
		if(undoHistory.getLast()!=null)
		{
		redoHistory.addBoard(new HistoryEntry(game.getPlayerTurn(),board.getConfiguration(),undoHistory.getLast().getOldPosition(),undoHistory.getLast().getNewPosition()));
		board.setBoard(undoHistory.getLast().getConfigBoard());
		game.setPlayerTurn(undoHistory.getLast().getPlayerTurn());
		gp.resetPiecesOnBoard();
		undoHistory.removeLast();
		updateGame.notifyAllObservers();
		}
	}
}
