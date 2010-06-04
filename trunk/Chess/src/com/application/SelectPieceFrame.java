package com.application;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.structures.*;
import javax.swing.*;
import com.structures.pieces.*;
import com.structures.Game;
import com.structures.LoadImagine;
public class SelectPieceFrame extends JDialog{
	private static final long serialVersionUID = 1L;
	private JButton queen,bishop,knight,rook;
	private Game game=Game.getGame();
	private LoadImagine im=new LoadImagine();
	private Piece newPiece; 
	private int idPiece;

	public Piece getNewPiece() {
		return newPiece;
	}
	
	public int getIdPiece() {
		return idPiece;
	}

	public SelectPieceFrame()
	{
		this.setModal(true);
		this.setSize(200, 80);
		this.setLocationRelativeTo(null);
		GridLayout gridLayout = new GridLayout();
		gridLayout.setRows(1);
		gridLayout.setColumns(4);
		this.setLayout(gridLayout);
		queen=new JButton();
		bishop=new JButton();
		knight=new JButton();
		rook=new JButton();
		queen.setName("queen");
		rook.setName("rook");
		bishop.setName("bishop");
		knight.setName("knight");

		if(game.getPlayerTurn()==1) 
		{
			queen.setIcon(im.getIcon("/piese/wq.png"));
			bishop.setIcon(im.getIcon("/piese/wb.png"));
			rook.setIcon(im.getIcon("/piese/wr.png"));
			knight.setIcon(im.getIcon("/piese/wn.png"));
		}
		else
		{
			queen.setIcon(im.getIcon("/piese/bq.png"));
			bishop.setIcon(im.getIcon("/piese/bb.png"));
			rook.setIcon(im.getIcon("/piese/br.png"));
			knight.setIcon(im.getIcon("/piese/bn.png"));

		}
		queen.addActionListener(this.new selectPiece());
		rook.addActionListener(this.new selectPiece());
		bishop.addActionListener(this.new selectPiece());
		knight.addActionListener(this.new selectPiece());

		this.add(queen);
		this.add(bishop);
		this.add(knight);
		this.add(rook);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

	}
	class selectPiece implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(((JButton)e.getSource()).getName()=="queen")
			{
				idPiece=game.getPlayerTurn()*10+8;
				newPiece=new Queen(game.getPlayerTurn());
			}
			if(((JButton)e.getSource()).getName()=="bishop")
			{
				idPiece=game.getPlayerTurn()*10+3;
				newPiece=new Bishop(game.getPlayerTurn());
			}
			if(((JButton)e.getSource()).getName()=="rook")
			{
				idPiece=game.getPlayerTurn()*10+5;
				newPiece=new Rook(game.getPlayerTurn());
			}
			if(((JButton)e.getSource()).getName()=="knight")
			{
				idPiece=game.getPlayerTurn()*10+2;
				newPiece=new Knight(game.getPlayerTurn());
			}
			dispose();
		}

	}

}
