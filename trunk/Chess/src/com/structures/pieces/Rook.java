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
	int p=0;
	for(int i=iPosition-1;i>=0;i--)
	{
		if((boardConfiguration[i][jPosition]==0)&&(p==0))
			rookMove[i][jPosition]=1;
		else
			p++;
	}
	p=0;
	for(int i=iPosition+1;i<8;i++)
	{
		if((boardConfiguration[i][jPosition]==0)&&(p==0))
			rookMove[i][jPosition]=1;
		else
			p++;
	}
	p=0;
	for(int j=jPosition-1;j>=0;j--)
	{
		if((boardConfiguration[iPosition][j]==0)&&(p==0))
			rookMove[iPosition][j]=1;
		else
			p++;
	}
	p=0;
	for(int j=jPosition+1;j<8;j++)
	{
		if((boardConfiguration[iPosition][j]==0)&&(p==0))
			rookMove[iPosition][j]=1;
		else
			p++;
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
