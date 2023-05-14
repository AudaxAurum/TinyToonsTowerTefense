package main;

import java.awt.Graphics;

public class Render {
	
	private Game game;

	
	public Render(Game game) {
		this.game= game;

	}
	public void render(Graphics g) {
		switch(GameStates.gameState) {
	
		case MENU:
				game.getMenu().render(g);
			break;
		case PLAYING:
				game.getPlaying().render(g);
			break;
		case ENDSCREEN:
				game.getSettings().render(g);
			break;
			
		}
	}
	

}