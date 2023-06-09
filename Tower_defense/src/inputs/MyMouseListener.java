	package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GameStates;

public class MyMouseListener implements MouseListener, MouseMotionListener {
	private Game game;
	
	public MyMouseListener( Game game) {
		this.game= game;
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		
		if (e.getButton() == MouseEvent.BUTTON3) {
			
			switch(GameStates.gameState) {
			case MENU:
				//game.getMenu().mouseRightClicked(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getPlaying().mouseRightClicked(e.getX(), e.getY());
				
				break;
			case ENDSCREEN:
				break;
			default:
				break;
			
			}
		}
			
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			
			switch(GameStates.gameState) {
			case MENU:
				game.getMenu().mouseLeftClicked(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getPlaying().mouseLeftClicked(e.getX(), e.getY());
				break;
			case ENDSCREEN:
				break;
			default:
				break;
			
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
