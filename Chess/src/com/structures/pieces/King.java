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
	for(int i=0;i<8;i++)
		for(int j=0;j<8;j++)
		{
			if((i==iPosition)&&(j>=jPosition-1)&&(j<=jPosition+1)&&(j!=jPosition))
				kingMove[i][j]=1;
			if((j==jPosition)&&(i>=iPosition-1)&&(i<=iPosition+1)&&(i!=iPosition))
				kingMove[i][j]=1;
			if((i>=iPosition-1)&&(i<=iPosition+1)&&(i!=iPosition)&&(j>=jPosition-1)&&(j<=jPosition+1)&&(j!=jPosition))
				kingMove[i][j]=1;
		}
		
	return kingMove;
	}
	public ImageIcon icon()
	{
		LoadImagine im=new LoadImagine();
		if(player==1) return im.getIcon("/piese/wk.png");
		return im.getIcon("/piese/bk.png");
	}
}
