package com.structures;
import javax.swing.ImageIcon;

import com.structures.pieces.NullPiece;


public class Game{

	Board gBoard;
	private static final long serialVersionUID = 1L;

	public Game()
	{	
		gBoard=new Board();
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
	}
