package com.structures.command;

public class HistoryEntry {
	private int playerTurn;
	private int[][] configBoard;
	public HistoryEntry(int playerTurn,int[][] cBoard)
	{
		configBoard=new int[cBoard.length][cBoard[0].length];
		this.playerTurn=playerTurn;
		for(int i=0;i<configBoard.length;i++)
			for(int j=0;j<configBoard[0].length;j++)
				configBoard[i][j]=cBoard[i][j];
	}
	public int getPlayerTurn() {
		return playerTurn;
	}
	public int[][] getConfigBoard() {
		return configBoard;
	}
}
