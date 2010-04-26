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
	public void posibleMove()
	{
		
	}
	public ImageIcon icon()
	{
		LoadImagine im=new LoadImagine();
		if(player==1) return im.getIcon("/piese/wq.png");
		return im.getIcon("/piese/bq.png");
	}
}
