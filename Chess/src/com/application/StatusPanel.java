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
		if(game.getPlayerTurn()==1)
			turn.setText("Player Turn: WHITE");
		else
			turn.setText("Player Turn: BLACK");
		this.add(turn);
	}
	public void update(Subject s)
	{
		if(game.getPlayerTurn()==1)
			turn.setText("Player Turn: WHITE");
		else
			turn.setText("Player Turn: BLACK");
	}
}
