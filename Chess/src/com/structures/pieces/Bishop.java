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

for(int i=2;i<iPosition;i++)
	bishopMove[i][i+(jPosition-iPosition)]=1;
return bishopMove;
}
public ImageIcon icon()
{ 
	LoadImagine im=new LoadImagine();
	if(player==1) return im.getIcon("/piese/wb.png");
	return im.getIcon("/piese/bb.png");
}
	
}
