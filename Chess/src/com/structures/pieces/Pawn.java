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
				if((iPosition==1)&&(boardConfiguration[iPosition+2][jPosition]==0))
				{
						pawnMove[iPosition+1][jPosition]=1;
						pawnMove[iPosition+2][jPosition]=1;
				}
				else
				{
					
					if(boardConfiguration[iPosition+1][jPosition]==0)
					{
					pawnMove[iPosition+1][jPosition]=1;
					}
				}
				if((jPosition>0)&&(jPosition<7)) 
				{
					if((boardConfiguration[iPosition+1][jPosition-1]!=0)&&(boardConfiguration[iPosition+1][jPosition-1]/10!=1))
					{
						if(boardConfiguration[iPosition+1][jPosition-1]!=29)
						pawnMove[iPosition+1][jPosition-1]=1;
					}
					if((boardConfiguration[iPosition+1][jPosition+1]!=0)&&(boardConfiguration[iPosition+1][jPosition+1]/10!=1))
					{
						if(boardConfiguration[iPosition+1][jPosition-1]!=29)
						pawnMove[iPosition+1][jPosition+1]=1;
					}
				}
				if((jPosition==7)&&(boardConfiguration[iPosition+1][jPosition-1]!=0)&&(boardConfiguration[iPosition+1][jPosition-1]/10!=1))
				{
					if(boardConfiguration[iPosition+1][jPosition-1]!=29)
					pawnMove[iPosition+1][jPosition-1]=1;
				}
				if((jPosition==0)&&(boardConfiguration[iPosition+1][jPosition+1]!=0)&&(boardConfiguration[iPosition+1][jPosition+1]/10!=1))
				{
					if(boardConfiguration[iPosition+1][jPosition+1]!=29)
					pawnMove[iPosition+1][jPosition+1]=1;
				}
				
				
			}
		if(pTurn/10==2)
		{
			if((iPosition==6)&&(boardConfiguration[iPosition-2][jPosition]==0))
			{
					pawnMove[iPosition-1][jPosition]=1;
					pawnMove[iPosition-2][jPosition]=1;
			}
			else
			{
				if(boardConfiguration[iPosition-1][jPosition]==0)
				{
					pawnMove[iPosition-1][jPosition]=1;
				}
				if((jPosition>0)&&(jPosition<7)) 
				{
					if((boardConfiguration[iPosition-1][jPosition-1]!=0)&&(boardConfiguration[iPosition-1][jPosition-1]/10!=2))
					{
						if(boardConfiguration[iPosition-1][jPosition-1]!=19)
						pawnMove[iPosition-1][jPosition-1]=1;
					}
					if((boardConfiguration[iPosition-1][jPosition+1]!=0)&&(boardConfiguration[iPosition-1][jPosition+1]/10!=2))
					{
						if(boardConfiguration[iPosition-1][jPosition+1]!=19)
						pawnMove[iPosition-1][jPosition+1]=1;
					}
				}
				if((jPosition==7)&&(boardConfiguration[iPosition-1][jPosition-1]!=0)&&(boardConfiguration[iPosition-1][jPosition-1]/10!=2))
				{
					if(boardConfiguration[iPosition-1][jPosition-1]!=19)
					pawnMove[iPosition-1][jPosition-1]=1;
				}
				if((jPosition==0)&&(boardConfiguration[iPosition-1][jPosition+1]!=0)&&(boardConfiguration[iPosition-1][jPosition+1]/10!=2))
				{
					if(boardConfiguration[iPosition-1][jPosition+1]!=19)
					pawnMove[iPosition-1][jPosition+1]=1;
				}
				
			}
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
