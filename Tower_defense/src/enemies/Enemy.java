package enemies;

import java.awt.Rectangle;

public class Enemy {
	private Rectangle bounds;
	private int health;
	private int enemyType;
	private int ID;
	// algemene variablen voor de movement
		int a = 0;   //a en b voor de het pad in de map af te lopen
		int b = 3;
		float x;
		float y;
		int verplaatsenx = 0;
		int verplaatseny = 0;
		int nrboven = 1;
		int nronder = 1;
		int nrrechts = 1;
		int nrlinks = 1;
		int hulp = 0;
		int go = 0;
		// tot hier algemene variablen voor de movenemnt
	
	public Enemy(float x, float y, int Id, int enemyType) {
		this.x = x;
		this.y =y;
		this.ID = ID;
		this.enemyType = enemyType;
		bounds = new Rectangle((int) x, (int) y , 32, 32);	
	}
	//nog functies voor de movement
		void onder(float hoeveel) {
			this.verplaatsenx = 0;
			this.verplaatseny = 0;
			if (y < a*64 + hoeveel) {
				verplaatseny = 1;
				go = 0;
			} 
			else {
				go = 1;
				nrboven = 0;
				nronder = 1;
				nrrechts = 1;
				nrlinks = 1;
				verplaatseny = 0;
				if (hulp == 1) {
					a = a + 1;
				}

			}
		}
		void boven(float hoeveel) {
			this.verplaatsenx = 0;
			this.verplaatseny = 0;
			if (y > a*64) {
				verplaatseny = -1;
				go = 0;
			} 
			else {
				go = 1;
				if (hulp == 1) {
					a = a - 1;
				}
				nrboven = 1;
				nronder = 0;
				nrrechts = 1;
				nrlinks = 1;
				verplaatseny = 0;
			}
		}
		void rechts(float hoeveel) {
			this.verplaatsenx = 0;
			this.verplaatseny = 0;
			if (x < b*64 + hoeveel) {
				verplaatsenx = 1;
				go = 0;
			} 
			else {
				go = 1;
				if (hulp == 1) {
					b = b + 1;
				}
				nrboven = 1;
				nronder = 1;
				nrrechts = 1;
				nrlinks = 0;
				verplaatsenx = 0;
			}
			
		}
		void links(float hoeveel) {
			this.verplaatsenx = 0;
			this.verplaatseny = 0;
			if (x > b*64) {
				verplaatsenx = -1;
				go = 0;
			} 
			else {
				go = 1;
				if (hulp == 1) {
					b = b - 1;
				}
				nrboven = 1;
				nronder = 1;
				nrrechts = 0;
				nrlinks = 1;
				verplaatsenx = 0;
			}
			
		}
		//hieronder de echte movement
		public void movement(float snelheid, int startvak_a, int startvak_b, int[][] map) { //vragen hoe zei tit zouden aanpakken
			
			//a = startvak_a;   //a en b voor de het pad in de map af te lopen
			//b = startvak_b;   //moeten nog wat visual changes gebeuren
			if (a == 0) {
				nrboven = 0;
			}
			if (b == 0) {
				nrlinks = 0;
			}
			if (a == 9) {
				nronder = 0;
				}
			if (b == 16) {
				nrrechts = 0;
			}
			if (map[a][b] == 1 || map[a][b] == 3) {
				if (!(nronder == 0) && !((map[a+1][b] == 0) || (map[a+1][b] == 4)) && nrboven == 0) {
					hulp = 1;
					onder(64);
				}
				if (a > 0) {
				if (!(nrboven == 0) && !((map[a-1][b] == 0) || (map[a-1][b] == 4)) && nronder == 0) {
					hulp = 1;
					boven(64);
				}}
				if (!(nrrechts == 0) && !((map[a][b+1] == 0) || (map[a][b+1] == 4)) && nrlinks == 0) {
					hulp = 1;
					rechts(64);
				}
				if (b > 0) {
				if (!(nrlinks == 0) && !((map[a][b-1] == 0) || (map[a][b-1] == 4)) && nrrechts == 0) {
					hulp = 1;
					links(64);
				}}
			}
			if (map[a][b] == 2) {
				if (!(nrrechts == 0) && !((map[a][b+1] == 0) || (map[a][b+1] == 4)) && nrboven == 0) {
					hulp = 0;
					onder(32);
					if (go == 1) {
						hulp = 1;
						rechts(32);
					}
					
				}
				if (b > 0) {
				if (!(nrlinks == 0) && !((map[a][b-1] == 0) || (map[a][b-1] == 4)) && nronder == 0) {
					hulp = 0;
					boven(32);
					if (go == 1) {
						hulp = 1;
						links(32);
					}
				}}
				if (a > 0) {
				if (!(nrboven == 0) && !((map[a-1][b] == 0) || (map[a-1][b] == 4)) && nrlinks == 0) {
					hulp = 0;
					rechts(32);
					if (go == 1) {
						hulp = 1;
						boven(32);
					}
				}}
				if (!(nronder == 0) && !((map[a+1][b] == 0) || (map[a+1][b] == 4)) && nrrechts == 0) {
					hulp = 0;
					links(32);
					if (go == 1) {
						hulp = 1;
						onder(32);
					}
				}
				if (b > 0) {
				if (!(nrlinks == 0) && !((map[a][b-1] == 0) || (map[a][b-1] == 4)) && nrboven == 0) {
					hulp = 0;
					onder(32);
					if (go == 1) {
						hulp = 1;
						links(32);
					}
				}}
				if (!(nrrechts == 0) && !((map[a][b+1] == 0) || (map[a][b+1] == 4)) && nronder == 0) {
					hulp = 0;
					boven(32);
					if (go == 1) {
						hulp = 1;
						rechts(32);
					}
				}
				if (!(nronder == 0) && !((map[a+1][b] == 0) || (map[a+1][b] == 4)) && nrlinks == 0) {
					hulp = 0;
					rechts(32);
					if (go == 1) {
						hulp = 1;
						onder(32);	
					}
				}
				if (a > 0) {
				if (!(nrboven == 0) && !((map[a-1][b] == 0) || (map[a-1][b] == 4)) && nrrechts == 0) {
					hulp = 0;
					links(32);
					if (go == 1) {
						hulp = 1;
						boven(32);
					}
				}}
			}
			if (map[a][b] == 5) {
				verplaatsenx = 0;
				verplaatseny = 0;
				System.out.println("einde");
			}
			y = y + verplaatseny*snelheid;
			x = x + verplaatsenx*snelheid;
			
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

}
