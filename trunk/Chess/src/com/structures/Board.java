package com.structures;
import com.structures.pieces.*;
public class Board {
public Piece[][] mat=new Piece[8][8];
public int[][] configBoard = { 
	    { 15,12,13,18,19,13,12,15}, 
	    { 11,11,11,11,11,11,11,11}, 
	    { 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0, 0, 0, 0 }, 
	    { 0, 0, 0, 0, 0, 0, 0, 0 },
	    { 21,21,21,21,21,21,21,21}, 
	    { 25,22,23,28,29,23,22,25}};
public Board()
{
updateTable();
}
public int[][] getConfiguration()
{
	return configBoard;
}
private Piece partID(int player,int id)
{
  switch(id){
	  case 1:{ return new Pawn(player);}
	  case 2: return new Knight(player);
	  case 3: return new Bishop(player);
	  case 5: return new Rook(player);
	  case 8: return new Queen(player);
	  case 9: return new King(player);
	  
  }
  return new NullPiece();
	  
}
private void updateTable()
{
	for(int i=0;i<8;i++)
		for(int j=0;j<8;j++)
			this.mat[i][j]=partID(configBoard[i][j]/10,configBoard[i][j]%10);
}
}
