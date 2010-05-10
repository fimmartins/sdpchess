package com.structures;
import com.structures.pieces.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Game extends JPanel{
	boolean butActive=false;
	JButton movePiece=new JButton();
	Board gBoard=new Board();
	JButton[][] buttons=new JButton[8][8];
	private static final long serialVersionUID = 1L;

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
				posibleMoves=gBoard.mat[position/10][position%10].posibleMove(gBoard.configBoard[position/10][position%10],position/10, position%10, gBoard.configBoard);
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
				int movedPiece;
				movedPiece=gBoard.configBoard[pieceInitialPosition/10][pieceInitialPosition%10];
				gBoard.configBoard[pieceInitialPosition/10][pieceInitialPosition%10]=0;
				gBoard.configBoard[pieceNewPosition/10][pieceNewPosition%10]=movedPiece;
				
				Piece movedPieceObject=gBoard.mat[pieceInitialPosition/10][pieceInitialPosition%10];
				gBoard.mat[pieceInitialPosition/10][pieceInitialPosition%10]=new NullPiece();
				gBoard.mat[pieceNewPosition/10][pieceNewPosition%10]=movedPieceObject;
				butActive=false;
				drawBoardColors();
				}
			}
				
		}
	}
	public Game()
	{	
	this.setSize(500, 500);
	this.setVisible(true);
	GridLayout gridLayout = new GridLayout();
	gridLayout.setRows(8);
	gridLayout.setColumns(8);
	this.setLayout(gridLayout);
	setPiecesOnBoard();
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
	private void setPiecesOnBoard()
	{
		for(int i=0;i<buttons.length;i++)
			for(int j=0;j<buttons.length;j++)
			{
				buttons[i][j]=new JButton();
				buttons[i][j].setIcon(gBoard.mat[i][j].icon());
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
}
