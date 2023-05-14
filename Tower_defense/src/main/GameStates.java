package main;

public enum GameStates {

	PLAYING,
	ENDSCREEN,
	VICTORY,
	MENU;
	
	public static void SetGameState(GameStates state) {
			gameState= state;
	}
	
	public static GameStates gameState = MENU;
	
	
	
}
