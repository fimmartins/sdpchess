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
	int[][] bishopMoves=new int[8][8];
	for(int i=0;i<bishopMoves.length;i++)
		for(int j=0;j<bishopMoves[0].length;j++)
		{
			int tmp=i*10+j;
			int position=iPosition*10+jPosition;
			if((position-tmp)%11==0) 
			{
				bishopMoves[i][j]=1;
			}
			if((position-tmp)%9==0)
			{
				bishopMoves[i][j]=1;
			}
		}
	return bishopMoves;
	}
	public ImageIcon icon()
	{
		LoadImagine im=new LoadImagine();
		if(player==1) return im.getIcon("/piese/wk.png");
		return im.getIcon("/piese/bk.png");
	}
}
