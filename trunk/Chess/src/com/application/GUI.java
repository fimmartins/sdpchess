package com.application;
import javax.swing.*;

import com.structures.observer.Subject;

import java.awt.*;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public GUI()
	{

		this.setSize(1000, 500);
		this.setLocationRelativeTo(null);
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(1);
		gridLayout.setColumns(2);
		this.setLayout(gridLayout);
		GamePanel gp=new GamePanel();
		StatusPanel sp=new StatusPanel();
		this.add(gp);
		this.add(sp);
		Subject updateGame=Subject.getSubject();
		updateGame.attach(sp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
}
