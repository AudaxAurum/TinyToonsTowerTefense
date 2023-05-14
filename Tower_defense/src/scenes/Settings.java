package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpz.LoadSave;
import main.Game;

public class Settings extends GameScene implements SceneMethods {
	
	//private BufferedImage Vic;
	
	public Settings(Game game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		
		drawVictory(g);
		/*g.setColor(Color.BLUE);
		g.fillRect(0,0 , Constants.xScherm, Constants.yScherm);*/
	}

	@Override
	public void mouseLeftClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	private void drawVictory(Graphics g) {
		BufferedImage VicImg  =  LoadSave.getVictory();
		g.drawImage(VicImg, 0, 0, 1024, 676, null);
	}
}