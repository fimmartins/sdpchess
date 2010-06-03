package com.structures.command;
import java.util.*;
public class HistoryBoard {
	ArrayList <HistoryEntry> history;
	public HistoryBoard()
	{
		history=new ArrayList<HistoryEntry>();
	}
	public void addBoard(HistoryEntry x)
	{
		history.add(x);
		System.out.println("************");
		System.out.println(x.toString());
		System.out.println("************");
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
		return history.get(history.size()-1);
	}
}
