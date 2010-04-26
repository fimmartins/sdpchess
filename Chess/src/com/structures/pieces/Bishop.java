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
public void posibleMove()
{

}
public ImageIcon icon()
{ 
	LoadImagine im=new LoadImagine();
	if(player==1) return im.getIcon("/piese/wb.png");
	return im.getIcon("/piese/bb.png");
}
	
}
