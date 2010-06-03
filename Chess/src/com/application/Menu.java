package com.application;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.structures.command.*;
public class Menu extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private JMenu edit,game;
	private JMenuItem undo, redo ,save ,load ,newGame;
	
	private TaskPerform task;
	private Undo undoTask;
	private Redo redoTask;
	private NewGame newGameTask;
	public Menu()
	{
		initMenu();
	}
	private void initMenu()
	{
		task=new TaskPerform();
		redoTask=new Redo();
		undoTask=new Undo();
		newGameTask=new NewGame();
		
		task.addTask(undoTask,"Undo");
		task.addTask(redoTask, "Redo");
		task.addTask(newGameTask, "New");
		
		game=new JMenu("Game");
		edit=new JMenu("Edit");
		undo=new JMenuItem("Undo");
		redo=new JMenuItem("Redo");
		save=new JMenuItem("Save");
		load=new JMenuItem("Load");
		newGame=new JMenuItem("New");
		
		undo.addActionListener(this.new undoListener());
		redo.addActionListener(this.new redoListener());
		newGame.addActionListener(this.new newListener());
		
		game.add(newGame);
		game.add(save);
		game.add(load);
		edit.add(undo);
		edit.add(redo);
		
		this.add(game);
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
	class newListener implements ActionListener
	{
	 public void actionPerformed(ActionEvent e) {
	        task.doTask("New");
	    }
	}

}
