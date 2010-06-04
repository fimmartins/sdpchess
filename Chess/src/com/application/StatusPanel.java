package com.application;
import java.awt.GridLayout;

import javax.swing.*;
import com.structures.*;
import com.structures.observer.Observer;
import com.structures.observer.Subject;
public class StatusPanel extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;
	private Game game=Game.getGame();
	private JLabel turn,check,st;
	public StatusPanel()
	{
		initStatusPanel();
	}
	private void initStatusPanel()
	{
		this.setSize(100, 500);
		this.setVisible(true);
		GridLayout panelGridLayout = new GridLayout();
		panelGridLayout.setRows(15);
		panelGridLayout.setColumns(1);
		this.setLayout(panelGridLayout);
		addStats();
	}
	private void addStats()
	{
		st=new JLabel("Game Status");
		this.add(st);
		turn=new JLabel();
		if(game.getPlayerTurn()==1)
			turn.setText("Player Turn: WHITE");
		else
			turn.setText("Player Turn: BLACK");
		this.add(turn);
		check=new JLabel();
		if(game.isCheck())
		{
			check.setText("You are in check!");
			if(game.isCheckMate())
				check.setText("CHECK MATE");
		}
		else
			check.setText("");
		this.add(check);
		
		
	}
	public void update(Subject s)
	{
		if(game.getPlayerTurn()==1)
			turn.setText("Player Turn: WHITE");
		else
			turn.setText("Player Turn: BLACK");
		
		if(game.isCheck())
		{
			check.setText("You are in check!");
			if(game.isCheckMate())
				check.setText("CHECK MATE");
		}
		else
			check.setText("");
	}
}
