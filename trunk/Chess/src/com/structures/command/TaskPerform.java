package com.structures.command;

import java.util.*;
public class TaskPerform {
private ArrayList<TaskEntry> taskList;
public TaskPerform() {
taskList = new ArrayList<TaskEntry>();
}
public void addTask(Task task,String name) {
TaskEntry te = new TaskEntry(task,name);
taskList.add(te);
}
public Iterator<TaskEntry> getTasks() {
return taskList.iterator();
}
public void doTask(String task) {
	for(int i=0;i<taskList.size();i++)
	if(taskList.get(i).getName()==task)
	{
		long now = System.currentTimeMillis();
		taskList.get(i).getTask().performTask();
		taskList.get(i).setTimeLastDone(now);
	}
	
}
}

