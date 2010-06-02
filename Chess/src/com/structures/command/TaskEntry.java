package com.structures.command;

public class TaskEntry {
	private Task task;
	private long timeLastDone;
	public TaskEntry(Task task) {
		this.task = task;
		this.timeLastDone = System.currentTimeMillis();
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