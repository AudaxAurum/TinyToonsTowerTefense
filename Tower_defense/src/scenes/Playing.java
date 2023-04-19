package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.Game;
import managers.EnemyManager;
import maplayers.MapLayer1;

public class Playing extends GameScene implements SceneMethods {

	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private EnemyManager enemyManager;
	
	public static BufferedImage rotateImage(BufferedImage src, int rotationAngle) {
	    double theta = (Math.PI * 2) / 360 * rotationAngle;
	    int width = src.getWidth();
	    int height = src.getHeight();
	    BufferedImage dest;
	    if (rotationAngle == 90 || rotationAngle == 270) {
	        dest = new BufferedImage(src.getHeight(), src.getWidth(), src.getType());
	    } else {
	        dest = new BufferedImage(src.getWidth(), src.getHeight(), src.getType());
	    }

	    Graphics2D graphics2D = dest.createGraphics();

	    if (rotationAngle == 90) {
	        graphics2D.translate((height - width) / 2, (height - width) / 2);
	        graphics2D.rotate(theta, height / 2, width / 2);
	    } else if (rotationAngle == 270) {
	        graphics2D.translate((width - height) / 2, (width - height) / 2);
	        graphics2D.rotate(theta, height / 2, width / 2);
	    } else {
	        graphics2D.translate(0, 0);
	        graphics2D.rotate(theta, width / 2, height / 2);
	    }
	    graphics2D.drawRenderedImage(src, null);
	    return dest;
	}
	
	public Playing(Game game) {
		super(game);
		importImg();
		loadSprites();
		
		enemyManager = new EnemyManager(this);
	}

	@Override
	public void render(Graphics g) {
		enemyManager.draw(g);
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 16; x++) {

				int i = MapLayer1.Level1[y][x];
				
				if (i == 1) {
					if (MapLayer1.Level1[y][x+1] == 0 || MapLayer1.Level1[y][x+1] == 4) {
						BufferedImage j = rotateImage(sprites.get(i), 90);
						g.drawImage(j, x*32, y*32, null);
					}
					else {
						g.drawImage(sprites.get(i), x*32, y*32, null);

					}
				}
				
				else if (i == 2) {
					if ((MapLayer1.Level1[y-1][x] != 0 && MapLayer1.Level1[y-1][x] != 4) && (MapLayer1.Level1[y][x+1] != 0 && MapLayer1.Level1[y][x+1] != 4)) {
						BufferedImage j = rotateImage(sprites.get(i), 90);
						g.drawImage(j, x*32, y*32, null);
					}
					else if ((MapLayer1.Level1[y+1][x] != 0 && MapLayer1.Level1[y+1][x] != 4) && (MapLayer1.Level1[y][x+1] != 0 && MapLayer1.Level1[y][x+1] != 4)) {
						BufferedImage j = rotateImage(sprites.get(i), 180);
						g.drawImage(j, x*32, y*32, null);
					}
					else if ((MapLayer1.Level1[y+1][x] != 0 && MapLayer1.Level1[y+1][x] != 4) && (MapLayer1.Level1[y][x-1] != 0 && MapLayer1.Level1[y][x-1] != 4)) {
						BufferedImage j = rotateImage(sprites.get(i), 270);
						g.drawImage(j, x*32, y*32, null);
					}
					else {
						g.drawImage(sprites.get(i), x*32, y*32, null);
					}
				}
				
				else {
					g.drawImage(sprites.get(i), x*32, y*32, null);
				}
			}
		}	
		
	}
	
private void importImg() {
	
	InputStream is = getClass().getResourceAsStream("/Atlas_4T.png");
	
	try {
		img = ImageIO.read(is);
	} catch (IOException e) {
		e.printStackTrace();
	}
}


private void loadSprites() {
	
	for (int y = 0; y < 1; y++) {
		for (int x = 0; x < 5; x++) {
			sprites.add(img.getSubimage(x*32, y*32, 32, 32));
		}
	}
}

@Override
public void mouseClicked(int x, int y) {
	// TODO Auto-generated method stub
	
}

}

