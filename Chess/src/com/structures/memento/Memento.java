package com.structures.memento;
import com.structures.command.*;;
public class Memento {
	private HistoryEntry state;
	public Memento(HistoryEntry state){
		this.state=state;
	}
	protected HistoryEntry getState(){
		return state;
	}
}
