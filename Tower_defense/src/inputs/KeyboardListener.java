package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static main.GameStates.*;

import main.GameStates;
import managers.EnemyManager;

public class KeyboardListener implements KeyListener {
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_A)
			System.out.println("a is pressed");
		
		else if (e.getKeyCode() == KeyEvent.VK_Q)
			GameStates.gameState =MENU;
		
		else if (e.getKeyCode() == KeyEvent.VK_W)
			GameStates.gameState =PLAYING;
	
		else if (e.getKeyCode() == KeyEvent.VK_E)
			GameStates.gameState =SETTINGS;
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
