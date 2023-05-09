package enemy;

import java.awt.Rectangle;

import helpz.Constants;
import managers.EnemyManager;

public class Enemy {
	private Rectangle bounds;
	private int health;
	private int enemyType;   // wss is oververving beter verschillen in subclasses 
	private int ID;
	// algemene variablen voor de movement
	private int a = 0;   //a en b voor de het pad in de map af te lopen
	private int b = 0;
	private float x;
	private float y;
	private int verplaatsenx = 0;
	private int verplaatseny = 0;
	private boolean nrboven = true;
	private boolean nronder = true;
	private boolean nrrechts = true;
	private boolean nrlinks = true;
	private boolean go = false;
	private boolean startcheck = true;
	// tot hier algemene variablen voor de movenemnt
	public int timer = 0;
	public int timerhelp = 0;
	
	private boolean alive = true;
	
	public Enemy(float x, float y, int ID, int enemyType) {
		this.ID = ID;
		this.enemyType = enemyType;
		bounds = new Rectangle((int) x, (int) y , Constants.DimSprite, Constants.DimSprite);
		
		setStartHealth();
	}
	public void dmg(int dmg) {
		this.health -= dmg;
		if (health <= 0) {
			alive = false;
		}
	}
	//nog functies voor de movement
		void onder(boolean hulp) {
			if (y < a*Constants.DimSprite - 20) {
				verplaatseny = 1;
				go = false;
				timer++;
			} 
			else {
				if (hulp == true) {
					a++;
				}
				go = true;
				nrboven = false;
				nronder = true;
				nrrechts = true;
				nrlinks = true;
				verplaatseny = 0;
			}
		}
		void boven(boolean hulp) {
			if (y > a*Constants.DimSprite - 18) {
				verplaatseny = -1;
				go = false;
				timer++;
			} 
			else {
				if (hulp == true) {
					a--;
				}
				go = true;
				nrboven = true;
				nronder = false;
				nrrechts = true;
				nrlinks = true;
				verplaatseny = 0;
			}
		}
		void rechts(boolean hulp) {
			if (x < b*Constants.DimSprite) {
				verplaatsenx = 1;
				go = false;
				timer++;
			} 
			else {
				if (hulp == true) {
					b++;
				}
				go = true;
				nrboven = true;
				nronder = true;
				nrrechts = true;
				nrlinks = false;
				verplaatsenx = 0;
			}
			
		}
		void links(boolean hulp) {
			if (x > b*Constants.DimSprite + 3) {
				verplaatsenx = -1;
				go = false;
				timer++;
			} 
			else {
				if (hulp == true) {
					b--;
				}
				go = true;
				nrboven = true;
				nronder = true;
				nrrechts = false;
				nrlinks = true;
				verplaatsenx = 0;
			}
			
		}
		//hieronder de echte movement
		public void movement(double snelheid, int[][] map) { //vragen hoe zei tit zouden aanpakken

			
			// temaken met de animation
			if (timer % 25 == 0 & timerhelp == 0) {
				timerhelp ++;
			}
			else if (timer % 25 == 0 & timerhelp == 1) {
				timerhelp++;
				}
			else if (timer % 25 == 0 & timerhelp == 2) {
				timerhelp++;
			}
			else if (timer % 25 == 0 & timerhelp == 3) {
				timerhelp = 0;
			}
			
			
			//start zoeken
			if (map[a][b] == 0 & startcheck == true & a < Constants.yMatrix - 1) {
				b = 0;
				a = a + 1;
				x = (b-1 * Constants.DimSprite);
				y = (a * Constants.DimSprite) - 22;
			}
			if (map[a][b] == 0 & a == Constants.yMatrix - 1) {
				a = 0;
				startcheck = false;
			}
			if (map[a][b] == 0 & b < Constants.xMatrix - 1 & startcheck == false) {
				b = b + 1;
				x = (b * Constants.DimSprite);
				y = (a * Constants.DimSprite) - Constants.DimSprite;
			}
			
			
			//randen checken
			if (a == 0) {
				nrboven = false;
			}
			if (b == 0) {
				nrlinks = false;
			}
			if (a == Constants.yMatrix - 1) {
				nronder = false;
			}
			if (b == Constants.xMatrix - 1) {
				nrrechts = false;
			}
			
			
			
			//movement code
			if (map[a][b] == 1 || map[a][b] == 3) {
				if (nrboven == false && !((map[a+1][b] == 0) || (map[a+1][b] == 4))) {
					onder(true);
				}
				if (a > 0) {
					if (nronder == false && !((map[a-1][b] == 0) || (map[a-1][b] == 4))) {
						boven(true);
					}
				}
				if (nrlinks == false && !((map[a][b+1] == 0) || (map[a][b+1] == 4))) {
					rechts(true);
				}
				if (b > 0) {
					if (nrrechts == false && !((map[a][b-1] == 0) || (map[a][b-1] == 4))) {
						links(true);
					}
				}
			}

			
			if (map[a][b] == 2) {
				if (nrboven == false) {
					onder(false);
					if (nrrechts == true && !((map[a][b+1] == 0) || (map[a][b+1] == 4))) {
						if (go == true) {
							rechts(true);
						}
					}
					else if (b > 0) {
						if (nrlinks == true && !((map[a][b-1] == 0) || (map[a][b-1] == 4))) {
							if (go == true) {
								links(true);
							}
						}
					}
				}
				
				else if (nronder == false) {
					boven(false);
					if (nrrechts == true && !((map[a][b+1] == 0) || (map[a][b+1] == 4))) {
						if (go == true) {
							rechts(true);
						}
					}
					if (b > 0) {
						if (nrlinks == true && !((map[a][b-1] == 0) || (map[a][b-1] == 4))) {
							if (go == true) {
								links(true);
							}
						}
					}
				}

				else if (nrlinks == false) {
					rechts(false);
					if (nronder == true && !((map[a+1][b] == 0) || (map[a+1][b] == 4))) {
						if (go == true) {
							onder(true);	
						}
					}
					if (a > 0) {
						if (nrboven == true && !((map[a-1][b] == 0) || (map[a-1][b] == 4))) {
							if (go == true) {
								boven(true);
							}
						}
					}
				}
				
				else if (nrrechts == false) {
					links(false);
					if (nronder == true && !((map[a+1][b] == 0) || (map[a+1][b] == 4))) {
						if (go == true) {
							onder(true);
						}
					}
					if (a > 0) {
						if (nrboven == true && !((map[a-1][b] == 0) || (map[a-1][b] == 4))) {
							if (go == true) {
								boven(true);
							}
						}
					}
				}
			}
			
			if (map[a][b] == 5) {
				System.out.println("einde"); //voorlopig
				alive = false;
			}
			y += verplaatseny*snelheid;
			x += verplaatsenx*snelheid;
		}

		
	private void setStartHealth() {
		health = helpz.Constants.Enemies.GetStartHealth(enemyType);
	}
		
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getEnemyType() {
		return enemyType;
	}

	public void setEnemyType(int enemyType) {
		this.enemyType = enemyType;
	}

	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		ID = ID;
	}
	public boolean getAlive() {
		return alive;
	}
	
}
