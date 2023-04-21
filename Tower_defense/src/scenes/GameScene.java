package scenes;

import main.Game;
// kan Game niet importen
public class GameScene {

	private Game game;
	
	public GameScene(Game game) {
		this.game = game;
	}
	
	
	public Game getGame() {
		return game;
	}
}
// wss waardeloos