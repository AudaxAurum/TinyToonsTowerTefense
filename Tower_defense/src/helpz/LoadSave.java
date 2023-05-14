package helpz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static BufferedImage getSpriteAtlas() {
		
		BufferedImage img = null;
		InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("Atlas_4T_64.png");
		
		try {
			img = ImageIO.read(is)		;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	public static BufferedImage getJan() {
		
		BufferedImage img = null;
		InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("jan.png");
		
		try {
			img = ImageIO.read(is)		;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
		
public static BufferedImage getVictory() {
		
		BufferedImage img = null;
		InputStream is = LoadSave.class.getClassLoader().getResourceAsStream("victory.png");
		
		try {
			img = ImageIO.read(is)		;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
