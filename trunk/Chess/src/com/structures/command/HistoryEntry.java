package com.structures.command;

public class HistoryEntry  implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int playerTurn;
	private int[][] configBoard;
	private String oldPosition,newPosition;
	public HistoryEntry(int playerTurn,int[][] cBoard)
	{
		configBoard=new int[cBoard.length][cBoard[0].length];
		this.playerTurn=playerTurn;
		for(int i=0;i<configBoard.length;i++)
		{
			for(int j=0;j<configBoard[0].length;j++)
			{
				configBoard[i][j]=cBoard[i][j];
				//System.out.print(configBoard[i][j]+" ");
			}
			//System.out.println();
		}
	}
	public HistoryEntry(int playerTurn,int[][] cBoard,String oldPosition,String newPosition)
	{
		configBoard=new int[cBoard.length][cBoard[0].length];
		this.playerTurn=playerTurn;
		this.oldPosition=oldPosition;
		this.newPosition=newPosition;
		for(int i=0;i<configBoard.length;i++)
		{
			for(int j=0;j<configBoard[0].length;j++)
			{
				configBoard[i][j]=cBoard[i][j];
			}
		}
	}
	public int getPlayerTurn() {
		return playerTurn;
	}
	public int[][] getConfigBoard() {
		return configBoard;
	}
	
	public String getOldPosition() {
		return oldPosition;
	}
	public String getNewPosition() {
		return newPosition;
	}
	public String toString()
	{
		String s="";
		s+=playerTurn+"\n";
		for(int i=0;i<configBoard.length;i++)
		{
			for(int j=0;j<configBoard[0].length;j++)
				s+=configBoard[i][j]+" ";
			s+="\n";
		}
		return s;
				
	}
}
