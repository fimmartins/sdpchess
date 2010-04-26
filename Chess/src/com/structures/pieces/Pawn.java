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
	public void posibleMove()
	{
		
	}
	public ImageIcon icon()
	{
		LoadImagine im=new LoadImagine();
		if(player==1) return im.getIcon("/piese/wp.png");
		return im.getIcon("/piese/bp.png");
	}
	
}
