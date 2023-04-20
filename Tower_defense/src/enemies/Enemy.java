package enemies;

import java.awt.Rectangle;

public class Enemy {
	private Rectangle bounds;
	private int health;
	private int enemyType;
	private int ID;
	// algemene variablen voor de movement
		int a = 0;   //a en b voor de het pad in de map af te lopen
		int b = 0;
		double x;
		double y;
		int verplaatsenx = 0;
		int verplaatseny = 0;
		int nrboven = 1;
		int nronder = 1;
		int nrrechts = 1;
		int nrlinks = 1;
		int hulp = 0;
		int go = 0;
		int ymatrix = 8;
		int xmatrix = 15;
		int startcheck = 1;//vatriable die eig in algemene variable moet
		// tot hier algemene variablen voor de movenemnt
	
	public Enemy(int Id, int enemyType) {
		this.ID = ID;
		this.enemyType = enemyType;
		bounds = new Rectangle((int) x, (int) y , 32, 32);	
	}
	//nog functies voor de movement
		void onder(float hoeveel) {
			this.verplaatsenx = 0;
			this.verplaatseny = 0;
			if (y < a*64 + hoeveel - 52) {
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
		void boven() {
			this.verplaatsenx = 0;
			this.verplaatseny = 0;
			if (y > a*64 - 18) {
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
			if (x < b*64 + hoeveel - 32) {
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
		void links() {
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
		public void movement(double snelheid, int[][] map) { //vragen hoe zei tit zouden aanpakken
			//a = startvak_a;   //a en b voor de het pad in de map af te lopen
			//b = startvak_b;   //moeten nog wat visual changes gebeuren
			if (map[a][b] == 0 & startcheck == 1 & a < ymatrix) {
				b = 0;
				a = a + 1;
				x = (b * 64) - 64;
				y = (a * 64) - 22;
			}
			if (map[a][b] == 0 & a == ymatrix) {
				a = 0;
				startcheck = 0;
			}
			if (map[a][b] == 0 & b < xmatrix & startcheck == 0) {
				b = b + 1;
				x = (b * 64);
				y = (a * 64) - 64;
			}
			if (a == 0) {
				nrboven = 0;
			}
			if (b == 0) {
				nrlinks = 0;
			}
			if (a == 8) {
				nronder = 0;
				}
			if (b == 15) {
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
					boven();
				}}
				if (!(nrrechts == 0) && !((map[a][b+1] == 0) || (map[a][b+1] == 4)) && nrlinks == 0) {
					hulp = 1;
					rechts(64);
				}
				if (b > 0) {
				if (!(nrlinks == 0) && !((map[a][b-1] == 0) || (map[a][b-1] == 4)) && nrrechts == 0) {
					hulp = 1;
					links();
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
					boven();
					if (go == 1) {
						hulp = 1;
						links();
					}
				}}
				if (a > 0) {
				if (!(nrboven == 0) && !((map[a-1][b] == 0) || (map[a-1][b] == 4)) && nrlinks == 0) {
					hulp = 0;
					rechts(32);
					if (go == 1) {
						hulp = 1;
						boven();
					}
				}}
				if (!(nronder == 0) && !((map[a+1][b] == 0) || (map[a+1][b] == 4)) && nrrechts == 0) {
					hulp = 0;
					links();
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
						links();
					}
				}}
				if (!(nrrechts == 0) && !((map[a][b+1] == 0) || (map[a][b+1] == 4)) && nronder == 0) {
					hulp = 0;
					boven();
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
					links();
					if (go == 1) {
						hulp = 1;
						boven();
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

	public double getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public double getY() {
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
