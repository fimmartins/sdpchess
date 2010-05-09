package com.structures;
import javax.swing.ImageIcon;
public interface Piece {
	int[][] posibleMove(int pTurn,int iPosition,int jPosition,int[][] configurationBoard);
	ImageIcon icon();
	
}
