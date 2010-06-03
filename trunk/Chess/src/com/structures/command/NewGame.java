package com.structures.command;
import com.application.GamePanel;
import com.structures.Board;
import com.structures.Game;
import com.structures.observer.Subject;

public class NewGame implements Task{

	
	private GamePanel gp=GamePanel.getGamePanel();
	private Board board=Board.getBoard();
	private Game game=Game.getGame();
	private Subject updateGame=Subject.getSubject();

	private UndoHistoryBoard undoHistory=UndoHistoryBoard.getHistoryBoard();
	private RedoHistoryBoard redoHistory=RedoHistoryBoard.getHistoryBoard();


	public void performTask()
	{
		board.resetBoard();
		gp.resetPiecesOnBoard();
		game.setPlayerTurn(1);
		undoHistory.resetHistoryBoard();
		redoHistory.resetHistoryBoard();
		updateGame.notifyAllObservers();
	}
}
