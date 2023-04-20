package scenes;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.Game;
import ui.MyButton;
import static main.GameStates.*;
public class Menu extends GameScene implements SceneMethods {

	private MyButton bPlaying, bQquit;
	public Menu(Game game) {
		super(game);
		initButtons();
		

	}

	private void initButtons() {
		
		int w = 105;
		int h= w/3;
		int x = 500/2-w/2;
		int y = 100;

		bPlaying = new MyButton(x, y, w, h ,"play");
		
	}

	@Override
	public void render(Graphics g) {

		drawButtons(g);
		 

	}

	private void drawButtons(Graphics g) {
		bPlaying.draw(g);

		
	}

	@Override
	public void mouseClicked(int x, int y) {
		if (bPlaying.getBounds().contains(x, y)) {
			SetGameState(PLAYING);
		}
		
	}
}

	
	