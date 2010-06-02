package com.structures.command;

import java.util.*;
public class TaskPerform {
private ArrayList<TaskEntry> taskList;
public TaskPerform(int maxTasks) {
taskList = new ArrayList<TaskEntry>(maxTasks);
}
public void addTask(Task task) {
TaskEntry te = new TaskEntry(task);
taskList.add(te);
}
public Iterator<TaskEntry> getTasks() {
return taskList.iterator();
}
public void doTask(Task t) {
	
	if(taskList.contains(t))
	{
		long now = System.currentTimeMillis();
		taskList.get(taskList.indexOf(t)).getTask().performTask();
		taskList.get(taskList.indexOf(t)).setTimeLastDone(now);
	}
}
}

