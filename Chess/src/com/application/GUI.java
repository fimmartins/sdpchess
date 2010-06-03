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
		gridLayout.setRows(2);
		gridLayout.setColumns(1);

		//this.setLayout(vb);
		
		JPanel gPanel=new JPanel();
		GridLayout gameLayout=new GridLayout();
		gameLayout.setColumns(2);
		gameLayout.setRows(1);
		gPanel.setLayout(gameLayout);
		
		GamePanel gp=GamePanel.getGamePanel();
		StatusPanel sp=new StatusPanel();
		Menu m=new Menu();
		this.add(m,BorderLayout.NORTH);
		gPanel.add(gp);
		gPanel.add(sp);
		this.add(gPanel,BorderLayout.CENTER);
		
		Subject updateGame=Subject.getSubject();
		updateGame.attach(sp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
}
