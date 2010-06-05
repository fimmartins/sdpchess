package com.application;
import java.awt.GridLayout;

import javax.swing.*;
import com.structures.*;
import com.structures.command.UndoHistoryBoard;
import com.structures.observer.Observer;
import com.structures.observer.Subject;
public class StatusPanel extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;
	private Game game=Game.getGame();
	private UndoHistoryBoard uhb=UndoHistoryBoard.getHistoryBoard();
	private JLabel turn,check,st;
	private JList list;
	private DefaultListModel listModel;
	private JScrollPane listScrollPane;
	private JPanel gameStats,historyList;
	public StatusPanel()
	{
		initStatusPanel();
	}
	private void initStatusPanel()
	{
		this.setSize(100, 500);
		this.setVisible(true);
		gameStats=new JPanel();
		historyList=new JPanel();
		gameStats.setLayout(new GridLayout(20,1));
		
		GridLayout panelGridLayout = new GridLayout();
		panelGridLayout.setRows(1);
		panelGridLayout.setColumns(2);
		this.setLayout(panelGridLayout);
		
		addStats();
	}
	private void addStats()
	{
		st=new JLabel("Game Status");
		gameStats.add(st);
		turn=new JLabel();
		if(game.getPlayerTurn()==1)
			turn.setText("Player Turn: WHITE");
		else
			turn.setText("Player Turn: BLACK");
		gameStats.add(turn);
		check=new JLabel();
		if(game.isCheck())
		{
			check.setText("You are in check!");
			if(game.isCheckMate())
				check.setText("CHECK MATE");
		}
		else
			check.setText("");
		gameStats.add(check);


		listModel=new DefaultListModel();
		for(int i=0;i<uhb.getHistory().size();i++)
			listModel.addElement(uhb.getHistory().get(i).getPlayerTurn());

		list=new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.setVisibleRowCount(5);
		listScrollPane = new JScrollPane(list);
		this.add(gameStats);
		this.add(listScrollPane);

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
		listModel.clear();
		for(int i=0;i<uhb.getHistory().size();i++)
			listModel.addElement("Player: "+uhb.getHistory().get(i).getPlayerTurn()+"   Move: "+uhb.getHistory().get(i).getOldPosition()+"->"+uhb.getHistory().get(i).getNewPosition());

	}
}
