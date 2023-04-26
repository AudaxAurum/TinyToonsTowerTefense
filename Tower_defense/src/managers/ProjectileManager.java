package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpz.LoadSave;
import objects.Projectile;
import scenes.Playing;

public class ProjectileManager {
	
	private Playing playing;
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private BufferedImage[] proj_imgs;
	
	public ProjectileManager(Playing playing) {
		this.playing = playing;
		importImgs();
	}
	
	private void importImgs() {
		BufferedImage atlas = LoadSave.getSpriteAtlas();
		proj_imgs = new BufferedImage[3];
		
		for(int i = 0; i < 3; i++)
			proj_imgs[i] = atlas.getSubimage(i,1,32,32); // verander waardes voor werkelijke loc
	}
	public void update() {
		
	}
	public void draw(Graphics g) {
		for (BufferedImage i : proj_imgs)
			g.drawImage(i,  300,  300,  null);
	}
}
