package com.structures.pieces;
import javax.swing.ImageIcon;
import com.structures.LoadImagine;
import com.structures.Piece;

public class Knight implements Piece{
	private int player;
	public Knight(int player)
	{
		this.player=player;
	}
	public int[][] posibleMove(int pTurn,int iPosition,int jPosition,int[][] boardConfiguration)
	{
	int[][] knightMoves=new int[8][8];
	for(int i=0;i<knightMoves.length;i++)
		for(int j=0;j<knightMoves[0].length;j++)
		{
			if(boardConfiguration[i][j]==0)
			{
			if((iPosition-2)==i && (jPosition-1)==j)
				knightMoves[i][j]=1;
			if((iPosition-2)==i && (jPosition+1)==j)
				knightMoves[i][j]=1;
			
			if((iPosition+2)==i && (jPosition-1)==j)
				knightMoves[i][j]=1;
			if((iPosition+2)==i && (jPosition+1)==j)
				knightMoves[i][j]=1;
			
			if((jPosition-2)==j && (iPosition-1)==i)
				knightMoves[i][j]=1;
			if((jPosition-2)==j && (iPosition+1)==i)
				knightMoves[i][j]=1;
			
			if((jPosition+2)==j && (iPosition-1)==i)
				knightMoves[i][j]=1;
			if((jPosition+2)==j && (iPosition+1)==i)
				knightMoves[i][j]=1;
			}
		}
	return knightMoves;
	}
	public ImageIcon icon()
	{
		LoadImagine im=new LoadImagine();
		if(player==1) return im.getIcon("/piese/wn.png");
		return im.getIcon("/piese/bn.png");
		
	}
}
