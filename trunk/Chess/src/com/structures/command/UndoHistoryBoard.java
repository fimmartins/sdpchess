package com.structures.command;
import java.util.*;
public class UndoHistoryBoard {
	private static UndoHistoryBoard instance;
	private ArrayList <HistoryEntry> history;
	private UndoHistoryBoard()
	{
		history=new ArrayList<HistoryEntry>();
	}
	public static UndoHistoryBoard getHistoryBoard()
	{
		if (instance==null)
			instance=new UndoHistoryBoard();
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
