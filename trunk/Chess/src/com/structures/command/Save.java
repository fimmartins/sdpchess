package com.structures.command;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.structures.Board;
import com.structures.Game;
import com.structures.memento.*;
public class Save implements Task{

	private Game game=Game.getGame();
	private Board board=Board.getBoard();

	public void performTask() {
		MementoTable table=new MementoTable();
		HistoryEntry save=new HistoryEntry(game.getPlayerTurn(),board.configBoard);
		Originator orig=new Originator(save);
		Memento memento=orig.getMemento();
		table.addMemento("mem1", memento);
		///Serializare
		ObjectOutputStream out;
		try {
			out = new ObjectOutputStream( new FileOutputStream("saves.out"));
			out.writeObject("Storage");
			out.writeObject(table);
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		///Deserializare
		//ObjectInputStream in =new ObjectInputStream( new FileInputStream("saves.out"));
		//@SuppressWarnings("unused")
		//String s = (String)in.readObject();/////la citire trebuie sa declari variabila cu tipul care lai scris
		//ArrayList<BinaryTree<String>> a2 = (ArrayList<BinaryTree<String>>)in.readObject();
	}
}
