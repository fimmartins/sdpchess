package com.structures.pieces;
import javax.swing.ImageIcon;
import com.structures.LoadImagine;
import com.structures.Piece;

public class King implements Piece{
	int player;
	public King(int player)
	{
		this.player=player;
	}
	public int[][] posibleMove(int pTurn,int iPosition,int jPosition,int[][] boardConfiguration)
	{
	int[][] kingMove=new int[8][8];
	return kingMove;
	}
	public ImageIcon icon()
	{
		LoadImagine im=new LoadImagine();
		if(player==1) return im.getIcon("/piese/wk.png");
		return im.getIcon("/piese/bk.png");
	}
}
