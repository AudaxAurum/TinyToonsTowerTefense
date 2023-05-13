package ui;

import static main.GameStates.PLAYING;
import static main.GameStates.SetGameState;

import java.awt.Color;
import java.awt.Graphics;
import ui.MyButton;

import helpz.Constants;
import scenes.Playing;

public class UpgradeBar {
	
	private int x, y, width, height;
	private Playing playing;
	private MyButton bCrusher,bArcher;

	public UpgradeBar(int x, int y, int width, int height, Playing playing) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.playing = playing;
		
	}
public void initButtons() {
		
		int w = 80;
		int h= 40;
		int x = 100;
		int y = 15;

		 this.bCrusher = new MyButton(x+100, y, w, h ,"Crusher");
		 this.bArcher = new MyButton(x, y, w, h ,"Archer");
		
	}
	
	public void drawbar(Graphics g) {
		g.setColor(new Color(46,25,13));
		g.fillRect(x, y, width, height);
	}
	public void drawvalues(Graphics g) {
		g.setColor(new Color(255,255,255));
		g.drawString("Health = " + playing.getCastle_health(), x, y + 15);
		g.drawString("Gold = " + playing.getGold(), x, y + 30 );
		g.drawString("Wave" + + playing.getCurrentWave() + "/" + playing.getWaves(), x, y + 45 );
	}
	//public void drawArcherButton(Graphics g) {

		//g.setColor(Color.GREEN);
		//g.fillRect(x+100, y+15, 80, 40);
		//g.setColor(Color.BLACK);
		//g.drawString("Archer", x+110,y+35);
	
//}
	//public void drawCrusherButton(Graphics g) {

		//g.setColor(Color.GREEN);
		//g.fillRect(x+200, y+15, 80, 40);
		//g.setColor(Color.BLACK);
		//g.drawString("Crusher", x+210,y+35);
	
//}
	public void render(Graphics g) {

		drawButtons(g);
		 

	}

	public void drawButtons(Graphics g) {
		bCrusher.draw(g);
		bArcher.draw(g);

		
	}

	public void mouseLeftClicked(int x, int y) {
		if (bCrusher.getBounds().contains(x, y)) {
			SetGameState(PLAYING);
		}
		
	}
	
}
