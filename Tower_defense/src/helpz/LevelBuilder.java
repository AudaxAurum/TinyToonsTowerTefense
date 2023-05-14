package helpz;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import maplayers.MapLayer1;

public class LevelBuilder {
		
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
	
	public void DrawMap(Graphics g, ArrayList<BufferedImage> sprites, int xMatrix, int yMatrix, int DimSprite, int[][] map) {
		for (int y = 0; y < yMatrix; y++) {
			for (int x = 0; x < xMatrix; x++) {

				int i = map[y][x];
				
				if (i == 1) {
					if (MapLayer1.Level1[y][x+1] == 0 || MapLayer1.Level1[y][x+1] == 4) {
						BufferedImage j = LevelBuilder.rotateImage(sprites.get(i), 90);
						g.drawImage(j, x*DimSprite, y*DimSprite, null);
					}
					else {
						g.drawImage(sprites.get(i), x*DimSprite, y*DimSprite, null);

					}
				}
				
				else if (i == 2) {
					if ((map[y-1][x] != 0 && map[y-1][x] != 4) && (map[y][x+1] != 0 && map[y][x+1] != 4)) {
						BufferedImage j = LevelBuilder.rotateImage(sprites.get(i), 90);
						g.drawImage(j, x*DimSprite, y*DimSprite, null);
					}
					else if ((map[y+1][x] != 0 && map[y+1][x] != 4) && (map[y][x+1] != 0 && map[y][x+1] != 4)) {
						BufferedImage j = LevelBuilder.rotateImage(sprites.get(i), 180);
						g.drawImage(j, x*DimSprite, y*DimSprite, null);
					}
					else if ((map[y+1][x] != 0 && map[y+1][x] != 4) && (map[y][x-1] != 0 && map[y][x-1] != 4)) {
						BufferedImage j = LevelBuilder.rotateImage(sprites.get(i), 270);
						g.drawImage(j, x*DimSprite, y*DimSprite, null);
					}
					else {
						g.drawImage(sprites.get(i), x*DimSprite, y*DimSprite, null);
					}
				}
				
				else {
					g.drawImage(sprites.get(i), x*DimSprite, y*DimSprite, null);
				}
			}
		}
	}
	
}

