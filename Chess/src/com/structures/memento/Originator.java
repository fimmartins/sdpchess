package com.structures.memento;
import com.structures.command.*;
public class Originator  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	public HistoryEntry save;
	public Originator(HistoryEntry save){
		this.save=save;
	}
	public HistoryEntry getSave(){
		return save;
	}
	public void setSave(HistoryEntry save)
	{
		this.save=save;
	}
	public Memento getMemento(){
		return new Memento(save);
	}
	public void setMemento(Memento m){
		save=m.getState();
	}
}
