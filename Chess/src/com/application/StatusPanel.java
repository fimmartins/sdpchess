package com.application;
import java.awt.GridLayout;

import javax.swing.*;
import com.structures.*;
public class StatusPanel extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;
	private Game game=Game.getGame();
	private JLabel turn;
	public StatusPanel()
	{
		initStatusPanel();
	}
	private void initStatusPanel()
	{
		this.setSize(100, 500);
		this.setVisible(true);
		GridLayout panelGridLayout = new GridLayout();
		panelGridLayout.setRows(5);
		panelGridLayout.setColumns(1);
		this.setLayout(panelGridLayout);
		addStats();
	}
	private void addStats()
	{
		turn=new JLabel();
		turn.setText("Player Turn: "+game.getPlayerTurn()+"");
		this.add(turn);
	}
	public void update(Subject s)
	{
		turn.setText("Player Turn: "+game.getPlayerTurn()+"");
	}
}
