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


public class GameScreen extends JPanel{
	
	int[][] Level1 = {
    		//1: gras, 2: rechte baan, 3: bocht, 4: kruispunt, 5: torenplek, 6: poort kasteel
    		{0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    		{0,0,0,1,0,0,0,0,4,0,0,0,2,1,2,0},
    		{0,2,1,2,0,0,0,0,1,0,0,0,1,4,1,0},
    		{0,1,0,0,0,0,0,0,2,1,1,1,3,1,2,0},
    		{0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
    		{0,1,0,0,2,1,1,1,1,1,1,1,3,1,2,0},
    		{0,1,0,0,1,0,0,0,0,0,0,0,1,4,1,0},
    		{0,2,1,1,2,0,0,0,0,0,0,0,2,1,2,0},
    		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    		
	};

	private Game game;
	
	private Dimension size;
	
	
	public GameScreen(Game game) {
		this.game = game;

		
		setPanelSize();
		
		
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
