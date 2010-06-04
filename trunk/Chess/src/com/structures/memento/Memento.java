package com.structures.memento;
import com.structures.command.*;;
public class Memento  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private HistoryEntry state;
	public Memento(HistoryEntry state){
		this.state=state;
	}
	protected HistoryEntry getState(){
		return state;
	}
}
