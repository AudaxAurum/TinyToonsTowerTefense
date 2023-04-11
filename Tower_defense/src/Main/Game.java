package Main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{
	
	private GameScreen gameScreen;
	private BufferedImage img;
	private Thread gameThread;
	
	private final double FPS_SET = 120.0;
	private final double UPS_SET = 60.0;
	
	public Game() {
		
		System.out.println("Code gestart");

		importImg();
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("4T");
        setLocationRelativeTo(null); //standaard in de hoek van het scherm
        gameScreen = new GameScreen(img);
        add(gameScreen);
        setResizable(false);
        pack();
        setVisible(true);

	}

	private void importImg() {
		
		InputStream is = getClass().getResourceAsStream("/Atlas_4T.png");
		
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		Game game = new Game();
		game.start();
	}

	private void start() {
		gameThread = new Thread(this) {};
		gameThread.start();
		
	}

	@Override
	public void run() {
		
		double timePerFrame = 1000000000.0 / FPS_SET;
		double timePerUpdate = 1000000000.0 / UPS_SET;
		
		long lastFrame = System.nanoTime();
		long lastUpdate = System.nanoTime();
		long lastTimeCheck = System.currentTimeMillis();
		
		int frames = 0;
		int updates = 0;
		
		long now;
		
		while (true) {
			
			now = System.nanoTime();
			
			if (now - lastFrame >= timePerFrame) {
				repaint();
				lastFrame = now;
				frames++;
			}
			
			if (now - lastUpdate >= timePerUpdate) {
				updateGame();
				lastUpdate = now;
				updates++;
			}
			
			if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
				lastTimeCheck = System.currentTimeMillis();
			}
		}
	}

	private void updateGame() {
		//doet nog niks
	}

}
