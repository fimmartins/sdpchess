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
			if(((boardConfiguration[i][j]==0)||(boardConfiguration[i][j]/10!=pTurn/10)))	
			{
				if((i==iPosition)&&(j>=jPosition-1)&&(j<=jPosition+1)&&(j!=jPosition))
					kingMove[i][j]=1;
				if((j==jPosition)&&(i>=iPosition-1)&&(i<=iPosition+1)&&(i!=iPosition))
					kingMove[i][j]=1;
				if((i>=iPosition-1)&&(i<=iPosition+1)&&(i!=iPosition)&&(j>=jPosition-1)&&(j<=jPosition+1)&&(j!=jPosition))
					kingMove[i][j]=1;
			}
		}
		//Mutarile sa nu se apropie de rege
			if((jPosition-2>=0)&&(iPosition+2<8)&&(iPosition-2>=0))
			{
				if(boardConfiguration[iPosition][jPosition-2]%10==9)	
				{
					kingMove[iPosition][jPosition-1]=0;
					kingMove[iPosition+1][jPosition-1]=0;
					kingMove[iPosition-1][jPosition-1]=0;
				}
				if(boardConfiguration[iPosition+1][jPosition-2]%10==9)
				{
					kingMove[iPosition][jPosition-1]=0;
					kingMove[iPosition+1][jPosition-1]=0;
				}
				if(boardConfiguration[iPosition-1][jPosition-2]%10==9)
				{
					kingMove[iPosition][jPosition-1]=0;
					kingMove[iPosition-1][jPosition-1]=0;
				}
				if(boardConfiguration[iPosition-2][jPosition-2]%10==9)
				{
					kingMove[iPosition-1][jPosition-1]=0;
				}
				if(boardConfiguration[iPosition+2][jPosition-2]%10==9)
				{
					kingMove[iPosition+1][jPosition-1]=0;
				}
				
			
			}
			if((jPosition+2<8)&&(iPosition+2<8)&&(iPosition-2>=0))
			{
				if(boardConfiguration[iPosition][jPosition+2]%10==9)
						
				{
					kingMove[iPosition][jPosition+1]=0;
					kingMove[iPosition+1][jPosition+1]=0;
					kingMove[iPosition-1][jPosition+1]=0;
				}
				if(boardConfiguration[iPosition+1][jPosition+2]%10==9)
				{
					kingMove[iPosition][jPosition+1]=0;
					kingMove[iPosition+1][jPosition+1]=0;
				}
				if(boardConfiguration[iPosition-1][jPosition+2]%10==9)
				{
					kingMove[iPosition][jPosition+1]=0;
					kingMove[iPosition-1][jPosition+1]=0;
				}
				if(boardConfiguration[iPosition-2][jPosition+2]%10==9)
				{
					kingMove[iPosition-1][jPosition+1]=0;
				}
				if(boardConfiguration[iPosition+2][jPosition+2]%10==9)
				{
					kingMove[iPosition+1][jPosition+1]=0;
				}
			}
			if((iPosition-2>=0)&&(jPosition+2<8)&&(jPosition-2>=0))
			{
				if(boardConfiguration[iPosition-2][jPosition]%10==9)
						
				{
					kingMove[iPosition-1][jPosition]=0;
					kingMove[iPosition-1][jPosition-1]=0;
					kingMove[iPosition-1][jPosition+1]=0;
				}
				if(boardConfiguration[iPosition-2][jPosition+1]%10==9)
				{
					kingMove[iPosition-1][jPosition]=0;
					kingMove[iPosition-1][jPosition+1]=0;
				}
				if(boardConfiguration[iPosition-2][jPosition-1]%10==9)
				{
					kingMove[iPosition-1][jPosition]=0;
					kingMove[iPosition-1][jPosition-1]=0;
				}
				if(boardConfiguration[iPosition-2][jPosition-2]%10==9)
				{
					kingMove[iPosition-1][jPosition-1]=0;
				}
				if(boardConfiguration[iPosition-2][jPosition+2]%10==9)
				{
					kingMove[iPosition-1][jPosition+1]=0;
				}
			}
			if((iPosition+2<8)&&(jPosition+2<8)&&(jPosition-2>=0))
			{
				if(boardConfiguration[iPosition+2][jPosition]%10==9)
				
				{
					kingMove[iPosition+1][jPosition]=0;
					kingMove[iPosition+1][jPosition-1]=0;
					kingMove[iPosition+1][jPosition+1]=0;
				}
				if(boardConfiguration[iPosition+2][jPosition+1]%10==9)
				{
					kingMove[iPosition+1][jPosition]=0;
					kingMove[iPosition+1][jPosition+1]=0;
				}
				if(boardConfiguration[iPosition+2][jPosition-1]%10==9)
				{
					kingMove[iPosition+1][jPosition]=0;
					kingMove[iPosition+1][jPosition-1]=0;
				}
				if(boardConfiguration[iPosition+2][jPosition-2]%10==9)
				{
					kingMove[iPosition+1][jPosition-1]=0;
				}
				if(boardConfiguration[iPosition+2][jPosition+2]%10==9)
				{
					kingMove[iPosition+1][jPosition+1]=0;
				}
				
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
