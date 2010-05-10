package com.structures.pieces;
import javax.swing.ImageIcon;
import com.structures.Piece;
public class NullPiece implements Piece{
	
	public int[][] posibleMove(int pTurn,int iPosition,int jPosition,int[][] boardConfiguration)
	{
	int[][] nullMove=new int[8][8];
	return nullMove;
	}
	public ImageIcon icon()
	{
	return new ImageIcon();
	}
}
