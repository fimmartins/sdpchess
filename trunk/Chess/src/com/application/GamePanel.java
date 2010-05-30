package com.application;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.structures.*;
public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private Game game=Game.getGame();
	private JButton[][] buttons=new JButton[8][8];
	private JButton movingPiece=new JButton();
	private Subject updateGame=Subject.getSubject();
	boolean moveIsActive=false;

	public GamePanel()
	{
		this.setSize(500, 500);
		this.setVisible(true);
		GridLayout panelGridLayout = new GridLayout();
		panelGridLayout.setRows(8);
		panelGridLayout.setColumns(8);
		this.setLayout(panelGridLayout);
		initiateGame();
	}
	private void initiateGame()
	{
		game.setPlayerTurn(1);
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
				buttons[i][j].setBorder(new JButton().getBorder());
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

			if(!moveIsActive)
			{

				movingPiece=((JButton)e.getSource());
				int position=Integer.parseInt(movingPiece.getName());
				if(game.getPlayerTurn()==game.getPiece(position/10,position%10)/10)
				{

					int [][] posibleMoves;
					posibleMoves=game.getPiecePosibleMove(position/10, position%10);
					int moveNr=0;

					for(int i=0;i<8;i++)
					{
						for(int j=0;j<8;j++)
							if(posibleMoves[i][j]==1)
							{
								buttons[i][j].setBackground(new Color(9,121,206));
								moveNr++;
							}
					}
					if(moveNr>0)
						if(game.getPiece(position/10,position%10)!=0)
						{
							moveIsActive=true;
							movingPiece.setBorder(BorderFactory.createLineBorder(Color.RED));
							System.out.println(movingPiece.getName());
						}
				}
			}
			else
			{
				JButton aux=((JButton)e.getSource());
				if(aux.getName()!=movingPiece.getName())
				{
					int pieceInitialPosition=Integer.parseInt(movingPiece.getName());
					int pieceNewPosition=Integer.parseInt(aux.getName());
					if(game.getPiecePosibleMove(pieceInitialPosition/10,pieceInitialPosition%10)[pieceNewPosition/10][pieceNewPosition%10]!=0)
					{
						aux.setIcon(movingPiece.getIcon());
						game.movePiece(pieceInitialPosition, pieceNewPosition);
						movingPiece.setIcon(null);
						moveIsActive=false;
						drawBoardColors();
						if(game.getPlayerTurn()==1)
							game.setPlayerTurn(2);
						else
							game.setPlayerTurn(1);
						updateGame.notifyAllObservers();
					}
				}

			}

		}
	}
}
