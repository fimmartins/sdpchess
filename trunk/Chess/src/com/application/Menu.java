package com.application;
import javax.swing.*;
public class Menu extends JMenuBar{
	private static final long serialVersionUID = 1L;
	public Menu()
	{
		initMenu();
	}
	private void initMenu()
	{
		JMenu edit=new JMenu("Edit");
		JMenuItem undo=new JMenuItem("Undo");
		JMenuItem redo=new JMenuItem("Redo");
		edit.add(undo);
		edit.add(redo);
		this.add(edit);
	}
}
