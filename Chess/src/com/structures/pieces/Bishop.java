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


for(int i=0;i<8;i++)
	for(int j=0;j<8;j++)
	{
		//ST.SUS
		if((i>=0 && i<iPosition)&&(j>=0 && j<jPosition))
			if((i-j)==(iPosition-jPosition))
				bishopMove[i][j]=1;
		//DR.SUS
		if((i>=0 && i<iPosition)&&(j>jPosition && j<=8))
			if((i+j)==(iPosition+jPosition))
				bishopMove[i][j]=1;
		//ST.JOS
		if((i>iPosition && i<=8)&&(j>=0 && j<jPosition))
			if((i+j)==(iPosition+jPosition))
				bishopMove[i][j]=1;
		//DR.JOS
		if((i>iPosition && i<=8)&&(j>jPosition && j<=8))
			if((i-j)==(iPosition-jPosition))
				bishopMove[i][j]=1;
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
