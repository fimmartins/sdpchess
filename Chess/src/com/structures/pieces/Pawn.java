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
		int[][] pawnMove=new int[8][8];
		if(pTurn/10==1)
			{
				if((iPosition==1)&&(boardConfiguration[iPosition+2][jPosition]==0))
				{
					if(boardConfiguration[iPosition+1][jPosition]==0)
					{
						pawnMove[iPosition+1][jPosition]=1;
						pawnMove[iPosition+2][jPosition]=1;
					}
				}
				else
				{
					if(iPosition+1<8)
					if(boardConfiguration[iPosition+1][jPosition]==0)
					{
					pawnMove[iPosition+1][jPosition]=1;
					}
				}
				if((jPosition>0)&&(jPosition<7)) 
				{
					if(iPosition+1<8)
					if((boardConfiguration[iPosition+1][jPosition-1]!=0)&&(boardConfiguration[iPosition+1][jPosition-1]/10!=1))
					{
						if(boardConfiguration[iPosition+1][jPosition-1]!=29)
						pawnMove[iPosition+1][jPosition-1]=2;
					}
					if(iPosition+1<8)
					if((boardConfiguration[iPosition+1][jPosition+1]!=0)&&(boardConfiguration[iPosition+1][jPosition+1]/10!=1))
					{
						if(boardConfiguration[iPosition+1][jPosition+1]!=29)
						pawnMove[iPosition+1][jPosition+1]=2;
					}
					
				}
				if((jPosition==7)&&(boardConfiguration[iPosition+1][jPosition-1]!=0)&&(boardConfiguration[iPosition+1][jPosition-1]/10!=1))
				{
					if(boardConfiguration[iPosition+1][jPosition-1]!=29)
					pawnMove[iPosition+1][jPosition-1]=2;
				}
				if((jPosition==0)&&(boardConfiguration[iPosition+1][jPosition+1]!=0)&&(boardConfiguration[iPosition+1][jPosition+1]/10!=1))
				{
					if(boardConfiguration[iPosition+1][jPosition+1]!=29)
					pawnMove[iPosition+1][jPosition+1]=2;
				}
				
			}
		if(pTurn/10==2)
		{
			if((iPosition==6)&&(boardConfiguration[iPosition-2][jPosition]==0))
			{
				if(boardConfiguration[iPosition-1][jPosition]==0)
				{
					pawnMove[iPosition-1][jPosition]=1;
					pawnMove[iPosition-2][jPosition]=1;
				}
			}
			else
			{
				if(iPosition-1>0)
				if(boardConfiguration[iPosition-1][jPosition]==0)
				{
					pawnMove[iPosition-1][jPosition]=1;
				}
			}
				if((jPosition>0)&&(jPosition<7)) 
				{
					
					if(jPosition>0 && iPosition>0)
					{
					if((boardConfiguration[iPosition-1][jPosition-1]!=0)&&(boardConfiguration[iPosition-1][jPosition-1]/10!=2))
					{
						if(boardConfiguration[iPosition-1][jPosition-1]!=19)
						pawnMove[iPosition-1][jPosition-1]=2;
					}
					
					if((boardConfiguration[iPosition-1][jPosition+1]!=0)&&(boardConfiguration[iPosition-1][jPosition+1]/10!=2))
					{
						if(boardConfiguration[iPosition-1][jPosition+1]!=19)
						pawnMove[iPosition-1][jPosition+1]=2;
					}
					}
					
				}
				if(iPosition-1>0)
				if((jPosition==7)&&(boardConfiguration[iPosition-1][jPosition-1]!=0)&&(boardConfiguration[iPosition-1][jPosition-1]/10!=2))
				{
					if(boardConfiguration[iPosition-1][jPosition-1]!=19)
					pawnMove[iPosition-1][jPosition-1]=2;
				}
				if((jPosition==0)&&(boardConfiguration[iPosition-1][jPosition+1]!=0)&&(boardConfiguration[iPosition-1][jPosition+1]/10!=2))
				{
					if(boardConfiguration[iPosition-1][jPosition+1]!=19)
					pawnMove[iPosition-1][jPosition+1]=2;
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
