package com.structures.command;

public class TaskEntry {
	private Task task;
	private long timeLastDone;
	private String name;
	public TaskEntry(Task task,String name) {
		this.task = task;
		this.name = name;
		this.timeLastDone = System.currentTimeMillis();
	}
	
	public String getName() {
		return name;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public long getTimeLastDone() {
		return timeLastDone;
	}
	public void setTimeLastDone(long t) {
		this.timeLastDone = t;
	}
}