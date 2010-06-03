package com.structures.command;
import java.util.*;
public class RedoHistoryBoard {
	private static RedoHistoryBoard instance;
	private ArrayList <HistoryEntry> history;
	private RedoHistoryBoard()
	{
		history=new ArrayList<HistoryEntry>();
	}
	public static RedoHistoryBoard getHistoryBoard()
	{
		if (instance==null)
			instance=new RedoHistoryBoard();
		return instance;
	}
	public void addBoard(HistoryEntry x)
	{
		history.add(x);
	}
	public void resetHistoryBoard()
	{
		history.clear();
	}
	public HistoryEntry getBoard(int index)
	{
		return history.get(index);
	}
	public HistoryEntry getFirst()
	{
		return history.get(0);
	}
	public HistoryEntry getLast()
	{
		if(!history.isEmpty())
			return history.get(history.size()-1);	
		else
			return null;
	}
	public void removeLast()
	{
		if(!history.isEmpty())
			history.remove(history.size()-1);
	}
}
