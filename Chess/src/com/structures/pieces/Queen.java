package com.structures.pieces;
import javax.swing.ImageIcon;
import com.structures.LoadImagine;
import com.structures.Piece;

public class Queen implements Piece{
	private int player;
	public Queen(int player)
	{
		this.player=player;
	}
	public int[][] posibleMove(int pTurn,int iPosition,int jPosition,int[][] boardConfiguration)
	{
	int[][] queenMoves=new int[8][8];
	int p=0;
	int k=1;
	for(int i=iPosition-1;i>=0;i--)
	{	
		if(jPosition-k>=0)
		{
			if((boardConfiguration[i][jPosition-k]==0)&&(p==0))
			{
				queenMoves[i][jPosition-k]=1;
				k++;
			}
			else
			{
				p++;
			}
			if((p==1)&&(boardConfiguration[i][jPosition-k]/10!=pTurn/10)&&(boardConfiguration[i][jPosition-k]%10!=9))
			{
				queenMoves[i][jPosition-k]=2;
			}
		}
	}
	p=0;
	k=1;
	for(int i=iPosition+1;i<8;i++)
	{
		if(jPosition+k<=7)
		{
			if((boardConfiguration[i][jPosition+k]==0)&&(p==0))
			{
				queenMoves[i][jPosition+k]=1;
				k++;
			}
			else
			{
				p++;
			}
			if((p==1)&&(boardConfiguration[i][jPosition+k]/10!=pTurn/10)&&(boardConfiguration[i][jPosition+k]%10!=9))
			{
				queenMoves[i][jPosition+k]=2;
			}
		}
	}
	p=0;
	k=1;
	for(int i=iPosition+1;i<8;i++)
	{
		if(jPosition-k>=0)
		{
			if((boardConfiguration[i][jPosition-k]==0)&&(p==0))
			{
				queenMoves[i][jPosition-k]=1;
				k++;
			}
			else
			{
				p++;
			}
			if((p==1)&&(boardConfiguration[i][jPosition-k]/10!=pTurn/10)&&(boardConfiguration[i][jPosition-k]%10!=9))
			{
				queenMoves[i][jPosition-k]=2;
			}
		}
	}
	p=0;
	k=1;
	for(int i=iPosition-1;i>=0;i--)
	{	
		if(jPosition+k<=7)
		{
			if((boardConfiguration[i][jPosition+k]==0)&&(p==0))
			{
				queenMoves[i][jPosition+k]=1;
				k++;
			}
			else
			{
				p++;
			}
			if((p==1)&&(boardConfiguration[i][jPosition+k]/10!=pTurn/10)&&(boardConfiguration[i][jPosition+k]%10!=9))
			{
				queenMoves[i][jPosition+k]=2;
			}
		}
	}
	p=0;
	for(int i=iPosition-1;i>=0;i--)
	{
		if((boardConfiguration[i][jPosition]==0)&&(p==0))
			queenMoves[i][jPosition]=1;
		else
			p++;
		if(((p==1)&&(pTurn/10!=boardConfiguration[i][jPosition]/10))&&(boardConfiguration[i][jPosition]%10!=9))
		{
			queenMoves[i][jPosition]=2;
		}
	}
	p=0;
	for(int i=iPosition+1;i<8;i++)
	{
		if((boardConfiguration[i][jPosition]==0)&&(p==0))
			queenMoves[i][jPosition]=1;
		else
			p++;
		if(((p==1)&&(pTurn/10!=boardConfiguration[i][jPosition]/10))&&(boardConfiguration[i][jPosition]%10!=9))
		{
			queenMoves[i][jPosition]=2;
		}
	}
	p=0;
	for(int j=jPosition-1;j>=0;j--)
	{
		if((boardConfiguration[iPosition][j]==0)&&(p==0))
			queenMoves[iPosition][j]=1;
		else
			p++;
		if(((p==1)&&(pTurn/10!=boardConfiguration[iPosition][j]/10))&&(boardConfiguration[iPosition][j]%10!=9))
		{
			queenMoves[iPosition][j]=2;
		}
	}
	p=0;
	for(int j=jPosition+1;j<8;j++)
	{
		if((boardConfiguration[iPosition][j]==0)&&(p==0))
			queenMoves[iPosition][j]=1;
		else
			p++;
		if(((p==1)&&(pTurn/10!=boardConfiguration[iPosition][j]/10))&&(boardConfiguration[iPosition][j]%10!=9))
		{
			queenMoves[iPosition][j]=2;
		}
	}
	return queenMoves;
	}
	public ImageIcon icon()
	{
		LoadImagine im=new LoadImagine();
		if(player==1) return im.getIcon("/piese/wq.png");
		return im.getIcon("/piese/bq.png");
	}
}
