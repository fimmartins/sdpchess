package com.structures;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
	private static final long serialVersionUID = 1L;
	public GUI()
	{
		
		this.setSize(500, 500);
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(1);
		gridLayout.setColumns(2);
		this.setLayout(gridLayout);
		this.add(new Game());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
