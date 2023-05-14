package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpz.Constants;
import helpz.LoadSave;
import main.Game;
import ui.MyButton;
import static main.GameStates.*;
public class Menu extends GameScene implements SceneMethods {

	private MyButton bPlaying;
	private BufferedImage jan;
	public Menu(Game game) {
		super(game);
		initButtons();
		

	}

	private void initButtons() {
		
		int w = 105;
		int h= w/3;
		int x = 100 + Constants.xScherm/2 - w;
		int y = Constants.yScherm/2 - h;

		bPlaying = new MyButton(x, y, w, h ,"   play");
		
	}

	@Override
	public void render(Graphics g) {
		
		drawJan(g);
		g.drawString("Druk op                                     om het spel te starten.", 460, 275);
		g.drawString("Je moet het kasteel verdedigen tegen de goblins. Als je kasteel te vaak geraakt word verlies je.", 450, 300);
		drawButtons(g);
		 
	}

	private void drawButtons(Graphics g) {
		bPlaying.draw(g);

		
	}
	
	private void drawJan(Graphics g) {
		BufferedImage janimg  =  LoadSave.getJan();
		jan = janimg.getSubimage(0, 0, 512, 256);
		g.drawImage(jan, 0, 170, 1024, 512, null);
	}
	

	@Override
	public void mouseLeftClicked(int x, int y) {
		if (bPlaying.getBounds().contains(x, y)) {
			SetGameState(PLAYING);
		}
		
	}
}

