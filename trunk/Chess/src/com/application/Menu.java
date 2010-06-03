package com.application;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.structures.command.*;
public class Menu extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private JMenu edit;
	private JMenuItem undo;
	private JMenuItem redo;
	
	private TaskPerform task;
	private Undo undoTask;
	private Redo redoTask;
	
	public Menu()
	{
		initMenu();
	}
	private void initMenu()
	{
		task=new TaskPerform();
		redoTask=new Redo();
		undoTask=new Undo();
		task.addTask(undoTask,"Undo");
		task.addTask(redoTask, "Redo");
		edit=new JMenu("Edit");
		undo=new JMenuItem("Undo");
		redo=new JMenuItem("Redo");
		undo.addActionListener(this.new undoListener());
		redo.addActionListener(this.new redoListener());
		edit.add(undo);
		edit.add(redo);
		
		this.add(edit);
	}
	class undoListener implements ActionListener
	{
	 public void actionPerformed(ActionEvent e) {
	        task.doTask("Undo");
	    }
	}
	class redoListener implements ActionListener
	{
	 public void actionPerformed(ActionEvent e) {
	        task.doTask("Redo");
	    }
	}

}
