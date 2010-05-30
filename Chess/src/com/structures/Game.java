package com.structures;
import javax.swing.ImageIcon;

import com.structures.pieces.NullPiece;


public class Game{
	private static Game instance;
	private Board gBoard;
	private int playerTurn;
	private static final long serialVersionUID = 1L;

	private Game()
	{	
		gBoard=Board.getBoard();
	}
	public static Game getGame()
	{
		if(instance==null)
		instance=new Game();
		return instance;
	}
	public ImageIcon getPieceIcon(int i,int j)
	{
		return gBoard.mat[i][j].icon();
	}
	public int[][] getPiecePosibleMove(int i,int j)
	{
		return gBoard.mat[i][j].posibleMove(gBoard.configBoard[i][j],i,j, gBoard.configBoard);
	}
	public void movePiece(int pieceInitialPosition,int pieceNewPosition)
	{
		int movedPiece;
		movedPiece=gBoard.configBoard[pieceInitialPosition/10][pieceInitialPosition%10];
		gBoard.configBoard[pieceInitialPosition/10][pieceInitialPosition%10]=0;
		gBoard.configBoard[pieceNewPosition/10][pieceNewPosition%10]=movedPiece;

		Piece movedPieceObject=gBoard.mat[pieceInitialPosition/10][pieceInitialPosition%10];
		gBoard.mat[pieceInitialPosition/10][pieceInitialPosition%10]=new NullPiece();
		gBoard.mat[pieceNewPosition/10][pieceNewPosition%10]=movedPieceObject;
	}
	public int getPiece(int i,int j)
	{
		return gBoard.configBoard[i][j];
	}
	public int getPlayerTurn() {
		return playerTurn;
	}
	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}
	
	}
