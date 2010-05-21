package com.structures.pieces;
import javax.swing.ImageIcon;
import com.structures.LoadImagine;
import com.structures.Piece;

public class Bishop implements Piece {
int player;
public Bishop(int player)
{
	this.player=player;
}
public int[][] posibleMove(int pTurn,int iPosition,int jPosition,int[][] boardConfiguration)
{
int[][] bishopMove=new int[8][8];

int p=0;
int k=1;
for(int i=iPosition-1;i>1;i--)
{	
	if(jPosition-k>=0)
	{
		if((boardConfiguration[i][jPosition-k]==0)&&(p==0))
		{
			bishopMove[i][jPosition-k]=1;
			k++;
		}
		else
		{
			p++;
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
			bishopMove[i][jPosition+k]=1;
			k++;
		}
		else
		{
			p++;
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
			bishopMove[i][jPosition-k]=1;
			k++;
		}
		else
		{
			p++;
		}
	}
}
p=0;
k=1;
for(int i=iPosition-1;i>1;i--)
{	
	if(jPosition+k<=7)
	{
		if((boardConfiguration[i][jPosition+k]==0)&&(p==0))
		{
			bishopMove[i][jPosition+k]=1;
			k++;
		}
		else
		{
			p++;
		}
	}
}


return bishopMove;
}
public ImageIcon icon()
{ 
	LoadImagine im=new LoadImagine();
	if(player==1) return im.getIcon("/piese/wb.png");
	return im.getIcon("/piese/bb.png");
}
	
}
