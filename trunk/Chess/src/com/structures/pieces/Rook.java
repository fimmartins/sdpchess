package com.structures.pieces;
import javax.swing.ImageIcon;
import com.structures.LoadImagine;
import com.structures.Piece;

public class Rook implements Piece{
	private int player;
	public Rook(int player)
	{
		this.player=player;
	}
	public int[][] posibleMove(int pTurn,int iPosition,int jPosition,int[][] boardConfiguration)
	{
	int[][] rookMove=new int[8][8];
	for(int i=0;i<rookMove.length;i++)
		for(int j=0;j<rookMove[0].length;j++)
		{
			if(boardConfiguration[i][j]==0)
			{
			if(iPosition==i)
				rookMove[i][j]=1;
			if(jPosition==j)
				rookMove[i][j]=1;
			}
			
		}
	return rookMove;
	}
	public ImageIcon icon()
	{
		LoadImagine im=new LoadImagine();
		if(player==1) return im.getIcon("/piese/wr.png");
		return im.getIcon("/piese/br.png");
	}
}
