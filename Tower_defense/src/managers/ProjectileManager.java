package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import enemy.Enemy;
import helpz.Constants;
import helpz.LoadSave;
import objects.Projectile;
import scenes.Playing;
import tower.Tower;

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
			proj_imgs[i] = atlas.getSubimage(i,0,Constants.DimSprite, Constants.DimSprite); // verander waardes voor werkelijke loc
	}
	
	//public void newProjectile(Tower t, Enemy e) {	
	//	projectiles.add (new Projectile(t.getX(),t.getY(),1,0,0,e.getX(),e.getY()));
	//}
	public void newProjectile(int x, int y, int xe, int ye) {	
		projectiles.add (new Projectile(x,y,1,0,0,xe,ye));
		//allemaal voorlopig voor te testen
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
				g.drawImage(proj_imgs[0], (int)p.getPosition().x, (int)p.getPosition().y, null );
			}
		}
	}
	
	private int getProjectileType(Tower t) {
		switch(t.getTowerType()) {
		// doet nog niks
		}
		return 0;
	}
}
