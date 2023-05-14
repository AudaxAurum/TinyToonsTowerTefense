package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemy.Enemy;
import helpz.Constants;
import helpz.LoadSave;
import objects.Projectile;
import tower.Tower;

public class ProjectileManager {
	
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private BufferedImage[] proj_imgs;
	public ProjectileManager() {
		importImgs();
	}
	
	private void importImgs() {
		BufferedImage atlas = LoadSave.getSpriteAtlas();
		proj_imgs = new BufferedImage[1];
		
			proj_imgs[0] = atlas.getSubimage(3*Constants.DimSprite,4*Constants.DimSprite,Constants.DimSprite, Constants.DimSprite); // verander waardes voor werkelijke loc
	}
	
	public void newProjectile(Tower t, int type,Enemy e) {	
		projectiles.add (new Projectile(t,type,e));
	}
	public void update() {
		for(Projectile p : projectiles) {
			if (p.alive) {
				p.move();
			}
		}
	}
	public void draw(Graphics g) {
		for(Projectile p : projectiles) {
			if (p.alive) {
				g.drawImage(proj_imgs[0], (int)p.getX(), (int)p.getY(), null );
			}
		}
	}
}
