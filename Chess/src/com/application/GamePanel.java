package com.application;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.structures.*;
import com.structures.command.Undo;
import com.structures.observer.Subject;
import java.util.*;
public class GamePanel extends JPanel{
	private static GamePanel instance;
	private static final long serialVersionUID = 1L;
	private Game game=Game.getGame();
	private JButton[][] buttons=new JButton[8][8];
	private JButton movingPiece=new JButton();
	private Subject updateGame=Subject.getSubject();
	private ArrayList<Integer> checkMovePiece;
	
	//private LoadImagine loadImg=new LoadImagine();
	boolean moveIsActive=false;

	private GamePanel()
	{
		this.setSize(500, 500);
		this.setVisible(true);
		GridLayout panelGridLayout = new GridLayout();
		panelGridLayout.setRows(8);
		panelGridLayout.setColumns(8);
		this.setLayout(panelGridLayout);
		initiateGame();
	}
	public static GamePanel getGamePanel()
	{
		if (instance==null)
		{
			instance=new GamePanel();
		}
		return instance;
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
				buttons[i][j].setFocusPainted(false);
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
		//buttons[3][3].setIcon(loadImg.getIcon("/images/selected.png"));
	}
	public void resetPiecesOnBoard()
	{
		for(int i=0;i<buttons.length;i++)
			for(int j=0;j<buttons.length;j++)
			{
				buttons[i][j].setIcon(game.getPieceIcon(i, j));
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
			if(!game.isGameover() || game.isDraw())
			{
				JButton aux=((JButton)e.getSource());
				int position=Integer.parseInt(aux.getName());
				if(game.getPlayerTurn()==game.getPiece(position/10,position%10)/10)
				{
					drawBoardColors();
					moveIsActive=false;
				}
				if(!moveIsActive)
				{
					movingPiece=((JButton)e.getSource());
					position=Integer.parseInt(movingPiece.getName());
					//System.out.println(position);
					boolean canMove=false;
					checkMovePiece=game.getUncheckPieces();
					if(game.isCheck() && checkMovePiece.contains(position))
						canMove=true;
					if(!game.isCheck())
						canMove=true;
					
					if(canMove)
						if(game.getPlayerTurn()==game.getPiece(position/10,position%10)/10)
						{

							int [][] posibleMoves;
							posibleMoves=game.getPiecePosibleMove(position/10, position%10);
							int moveNr=0;

							for(int i=0;i<8;i++)
							{
								for(int j=0;j<8;j++)
									if(posibleMoves[i][j]==1 || posibleMoves[i][j]==2 || posibleMoves[i][j]==3)
									{
										if(posibleMoves[i][j]==1)
											buttons[i][j].setBackground(new Color(9,121,206));
										if(posibleMoves[i][j]==2)
											buttons[i][j].setBackground(Color.RED);
										if(posibleMoves[i][j]==3)
											buttons[i][j].setBackground(Color.ORANGE);
										moveNr++;
									}
							}
							if(moveNr>0)
								if(game.getPiece(position/10,position%10)!=0)
								{
									moveIsActive=true;
									movingPiece.setBorder(BorderFactory.createLineBorder(Color.RED));
									//movingPiece.setIcon(loadImg.getIcon("/images/selected.png"));
									//movingPiece.setSelectedIcon(loadImg.getIcon("/images/selected.png"));
									//System.out.println(movingPiece.getName());
								}
						}
				}
				else
				{
					if(aux.getName()!=movingPiece.getName())
					{
						int pieceInitialPosition=Integer.parseInt(movingPiece.getName());
						int pieceNewPosition=Integer.parseInt(aux.getName());


						if(game.getPiecePosibleMove(pieceInitialPosition/10,pieceInitialPosition%10)[pieceNewPosition/10][pieceNewPosition%10]!=0)
						{
							if(game.getPiecePosibleMove(pieceInitialPosition/10,pieceInitialPosition%10)[pieceNewPosition/10][pieceNewPosition%10]==3)
							{
								if(pieceNewPosition==01)
								{
									game.movePiece(00, 02);
									buttons[0][2].setIcon(buttons[0][0].getIcon());
									buttons[0][0].setIcon(null);

								}
								if(pieceNewPosition==06)
								{
									game.movePiece(07, 05);
									buttons[0][5].setIcon(buttons[0][7].getIcon());
									buttons[0][7].setIcon(null);
								}
								if(pieceNewPosition==71)
								{
									game.movePiece(70, 72);
									buttons[7][2].setIcon(buttons[7][0].getIcon());
									buttons[7][0].setIcon(null);
								}
								if(pieceNewPosition==76)
								{
									game.movePiece(77, 75);
									buttons[7][5].setIcon(buttons[7][7].getIcon());
									buttons[7][7].setIcon(null);
								}
							}
							aux.setIcon(movingPiece.getIcon());
							game.movePiece(pieceInitialPosition, pieceNewPosition);
							movingPiece.setIcon(null);
							
							if(game.getPiece(pieceNewPosition/10, pieceNewPosition%10)%10==1 && ( (pieceNewPosition/10==7 && game.getPlayerTurn()==1) || (pieceNewPosition/10==0 && game.getPlayerTurn()==2)) )
							{
								
								SelectPieceFrame spf=new SelectPieceFrame();
								spf.setAlwaysOnTop(true);
								aux.setIcon(spf.getNewPiece().icon());
								game.setConfigBoardTo(pieceNewPosition, spf.getIdPiece());
								game.setPieceTo(pieceNewPosition, spf.getNewPiece());
							}
							moveIsActive=false;
							drawBoardColors();
							if(game.isCheck())
							{
								Undo un=new Undo();
								un.performTask();
							}
							else
							{
							if(game.getPlayerTurn()==1)
								game.setPlayerTurn(2);
							else
								game.setPlayerTurn(1);
							}
							if (game.isCheck())
							{
								//System.out.println("Check");
								checkMovePiece=game.getUncheckPieces();
								for(int i=0;i<checkMovePiece.size();i++)
									System.out.print(checkMovePiece.get(i)+" ");
								System.out.println();
								if(game.isCheckMate())
								{
									game.setGameover(true);
									//System.out.println("Check Mate");
								}
							}
							updateGame.notifyAllObservers();
						}
					}
				}
			}
		}
	}
}
