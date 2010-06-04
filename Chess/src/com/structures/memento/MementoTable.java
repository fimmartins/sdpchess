package com.structures.memento;
import java.util.Hashtable;
import java.util.Set;
public class MementoTable  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Hashtable<String,Memento> mementoHashtable=new Hashtable<String,Memento>();
	public void addMemento(String desc,Memento m)
	{
		mementoHashtable.put(desc, m);
	}
	public Memento getMemento(String desc){
		return mementoHashtable.get(desc);
	}
	public Set<String> getKeys(){
		return mementoHashtable.keySet();
	}
}
