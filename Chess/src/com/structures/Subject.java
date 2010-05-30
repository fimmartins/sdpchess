package com.structures;
import java.util.*;
public class Subject {
	private ArrayList<Observer> observers;
	private static Subject instance;
	private Subject()
	{
		observers=new ArrayList<Observer>();
	}
	public static Subject getSubject()
	{
		if(instance==null)
			instance=new Subject();
		return instance;
	}
	public void attach(Observer o)
	{
		observers.add(o);
	}
	public void detach(Observer o)
	{
		observers.remove(o);
	}
	public void notifyAllObservers()
	{
		for(Observer o:observers)
			o.update(this);
	}
}
