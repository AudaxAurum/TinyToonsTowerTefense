package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
//import Helpz;

import javax.swing.JPanel;

import inputs.KeyboardListener;
import inputs.MyMouseListener;


public class GameScreen extends JPanel{
	
	private Game game;
	
	private Dimension size;
	
	private MyMouseListener myMouselistener;
	private KeyboardListener keyboardlistener;
	
	public GameScreen(Game game) {
		this.game = game;

		
		setPanelSize();
		
		
	}
	
	public void initInputs(){
		myMouselistener= new MyMouseListener(game);
		keyboardlistener= new KeyboardListener();
		
		addMouseListener(myMouselistener);
		addMouseMotionListener(myMouselistener);
		addKeyListener(keyboardlistener); 
		
		requestFocus();
		
	}

	
	private void setPanelSize() {
		size = new Dimension(16*32,9*32);
		setMinimumSize(size);
		setPreferredSize(size);
		setMaximumSize(size);

	}


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		game.getRender().render(g);

	}

}
