package scenes;

import java.awt.Color;
import java.awt.Graphics;

import helpz.Constants;
import main.Game;

public class Settings extends GameScene implements SceneMethods {

	public Settings(Game game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.fillRect(0,0 , Constants.xScherm, Constants.yScherm);
	}

	@Override
	public void mouseLeftClicked(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}