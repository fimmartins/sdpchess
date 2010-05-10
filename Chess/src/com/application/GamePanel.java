package com.application;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.structures.Game;
public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Game game=new Game();
	JButton[][] buttons=new JButton[8][8];
	JButton movePiece=new JButton();
	boolean butActive=false;
	
	public GamePanel()
	{
		this.setSize(500, 500);
		this.setVisible(true);
		GridLayout panelGridLayout = new GridLayout();
		panelGridLayout.setRows(8);
		panelGridLayout.setColumns(8);
		this.setLayout(panelGridLayout);
		setPiecesOnBoard();
	}
	private void setPiecesOnBoard()
	{
		for(int i=0;i<buttons.length;i++)
			for(int j=0;j<buttons.length;j++)
			{
				buttons[i][j]=new JButton();
				buttons[i][j].setIcon(game.getPieceIcon(i, j));
				buttons[i][j].addActionListener(this.new move());
				buttons[i][j].setName(i+""+j);
				if(i%2==0)
					if(j%2==0)
						buttons[i][j].setBackground(Color.GRAY);
					else
						buttons[i][j].setBackground(Color.WHITE);
				else
					if(j%2==0)
						buttons[i][j].setBackground(Color.WHITE);
					else
						buttons[i][j].setBackground(Color.GRAY);
				this.add(buttons[i][j]);
			}
	}
	private void drawBoardColors()
	{
		for(int i=0;i<buttons.length;i++)
			for(int j=0;j<buttons.length;j++)
			{
				if(i%2==0)
					if(j%2==0)
						buttons[i][j].setBackground(Color.GRAY);
					else
						buttons[i][j].setBackground(Color.WHITE);
				else
					if(j%2==0)
						buttons[i][j].setBackground(Color.WHITE);
					else
						buttons[i][j].setBackground(Color.GRAY);
				this.add(buttons[i][j]);
			}
	}
	class move implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(!butActive)
			{
				if(((JButton)e.getSource()).getIcon()!=null)
				{
					butActive=true;
					movePiece=((JButton)e.getSource());
					int position=Integer.parseInt(movePiece.getName());
					int [][] posibleMoves;
					posibleMoves=game.getPiecePosibleMove(position/10, position%10);
					for(int i=0;i<8;i++)
					{
						for(int j=0;j<8;j++)
							if(posibleMoves[i][j]==1)
								buttons[i][j].setBackground(Color.BLUE);
					}
					System.out.println(movePiece.getName());
				}
			}
			else
			{
				JButton aux=((JButton)e.getSource());
				if(aux.getName()!=movePiece.getName())
				{
					aux.setIcon(movePiece.getIcon());
					movePiece.setIcon(null);
					int pieceInitialPosition=Integer.parseInt(movePiece.getName());
					int pieceNewPosition=Integer.parseInt(aux.getName());
					game.movePiece(pieceInitialPosition, pieceNewPosition);
					butActive=false;
					drawBoardColors();
				}
			}

		}
	}
}
