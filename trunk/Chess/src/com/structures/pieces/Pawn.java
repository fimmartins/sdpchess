package com.structures.pieces;
import javax.swing.ImageIcon;
import com.structures.LoadImagine;
import com.structures.Piece;

public class Pawn implements Piece{
	private int player;
	public Pawn(int player)
	{
		this.player=player;
	}
	public int[][] posibleMove(int pTurn,int iPosition,int jPosition,int[][] boardConfiguration)
	{
		System.out.println();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
			System.out.print(boardConfiguration[i][j]+" ");
			}
			System.out.println();
		}
		int[][] pawnMove=new int[8][8];
		if(pTurn/10==1)
		{
			pawnMove[iPosition+1][jPosition]=1;	
		}
		if(pTurn/10==2)
		{
			pawnMove[iPosition-1][jPosition]=1;	
		}
		return pawnMove;
	}
	public ImageIcon icon()
	{
		LoadImagine im=new LoadImagine();
		if(player==1) return im.getIcon("/piese/wp.png");
		return im.getIcon("/piese/bp.png");
	}

}
