package enemies;

import java.awt.Rectangle;

public class Enemy {
	private Rectangle bounds;
	private int health;
	private int enemyType;   // wss is oververving beter verschillen in subclasses 
	private int ID;
	// algemene variablen voor de movement
		int a = 0;   //a en b voor de het pad in de map af te lopen
		int b = 0;
		double x;
		double y;
		int verplaatsenx = 0;
		int verplaatseny = 0;
		boolean nrboven = true;
		boolean nronder = true;
		boolean nrrechts = true;
		boolean nrlinks = true;
		boolean hulp = false;
		boolean go = false;
		int ymatrix = 8;
		int xmatrix = 15;
		boolean startcheck = true;
		// tot hier algemene variablen voor de movenemnt
		int timer = 0;
		public int timerhelp = 0;
	
	public Enemy(int Id, int enemyType) {
		this.ID = ID;
		this.enemyType = enemyType;
		bounds = new Rectangle((int) x, (int) y , 32, 32);	
	}
	//nog functies voor de movement
		void onder(float hoeveel) {
			if (y < a*64 + hoeveel - 52) {
				verplaatseny = 1;
				go = false;
				timer++;
			} 
			else {
				go = true;
				nrboven = false;
				nronder = true;
				nrrechts = true;
				nrlinks = true;
				verplaatseny = 0;
				if (hulp == true) {
					a++;
				}

			}
		}
		void boven() {
			if (y > a*64 - 18) {
				verplaatseny = -1;
				go = false;
				timer++;
			} 
			else {
				go = true;
				if (hulp == true) {
					a--;
				}
				nrboven = true;
				nronder = false;
				nrrechts = true;
				nrlinks = true;
				verplaatseny = 0;
			}
		}
		void rechts(float hoeveel) {
			if (x < b*64 + hoeveel - 32) {
				verplaatsenx = 1;
				go = false;
				timer++;
			} 
			else {
				go = true;
				if (hulp == true) {
					b++;
				}
				nrboven = true;
				nronder = true;
				nrrechts = true;
				nrlinks = false;
				verplaatsenx = 0;
			}
			
		}
		void links() {
			if (x > b*64) {
				verplaatsenx = -1;
				go = false;
				timer++;
			} 
			else {
				go = true;
				if (hulp == true) {
					b--;
				}
				nrboven = true;
				nronder = true;
				nrrechts = false;
				nrlinks = true;
				verplaatsenx = 0;
			}
			
		}
		//hieronder de echte movement
		public void movement(double snelheid, int[][] map) { //vragen hoe zei tit zouden aanpakken
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
			
			
			
			if (map[a][b] == 0 & startcheck == true & a < ymatrix) {
				b = 0;
				a = a + 1;
				x = (b * 64) - 64;
				y = (a * 64) - 22;
			}
			if (map[a][b] == 0 & a == ymatrix) {
				a = 0;
				startcheck = false;
			}
			if (map[a][b] == 0 & b < xmatrix & startcheck == false) {
				b = b + 1;
				x = (b * 64);
				y = (a * 64) - 64;
			}
			
			
			
			if (a == 0) {
				nrboven = false;
			}
			if (b == 0) {
				nrlinks = false;
			}
			if (a == ymatrix) {
				nronder = false;
				}
			if (b == xmatrix) {
				nrrechts = false;
			}
			
			
			
			
			if (map[a][b] == 1 || map[a][b] == 3) {
				if (nrboven == false && !((map[a+1][b] == 0) || (map[a+1][b] == 4))) {
					hulp = true;
					onder(64);
				}
				if (a > 0) {
					if (nronder == false && !((map[a-1][b] == 0) || (map[a-1][b] == 4))) {
						hulp = true;
						boven();
					}
				}
				if (nrlinks == false && !((map[a][b+1] == 0) || (map[a][b+1] == 4))) {
					hulp = true;
					rechts(64);
				}
				if (b > 0) {
					if (nrrechts == false && !((map[a][b-1] == 0) || (map[a][b-1] == 4))) {
						hulp = true;
						links();
					}
				}
			}
			
			
			
			if (map[a][b] == 2) {
				if (nrboven == false) {
					hulp = false;
					onder(32);
					if (nrrechts == true && !((map[a][b+1] == 0) || (map[a][b+1] == 4))) {
						if (go == true) {
							hulp = true;
							rechts(32);
						}
					}
					else if (b > 0) {
						if (nrlinks == true && !((map[a][b-1] == 0) || (map[a][b-1] == 4))) {
							if (go == true) {
								hulp = true;
								links();
							}
						}
					}
				}
				
				else if (nronder == false) {
					hulp = false;
					boven();
					if (nrrechts == true && !((map[a][b+1] == 0) || (map[a][b+1] == 4))) {
						if (go == true) {
							hulp = true;
							rechts(32);
						}
					}
					if (b > 0) {
						if (nrlinks == true && !((map[a][b-1] == 0) || (map[a][b-1] == 4))) {
							if (go == true) {
								hulp = true;
								links();
							}
						}
					}
				}

				else if (nrlinks == false) {
					hulp = false;
					rechts(32);
					if (nronder == true && !((map[a+1][b] == 0) || (map[a+1][b] == 4))) {
						if (go == true) {
							hulp = true;
							onder(32);	
						}
					}
					if (a > 0) {
						if (nrboven == true && !((map[a-1][b] == 0) || (map[a-1][b] == 4))) {
							if (go == true) {
								hulp = true;
								boven();
							}
						}
					}
				}
				
				else if (nrrechts == false) {
					hulp = false;
					links();
					if (nronder == true && !((map[a+1][b] == 0) || (map[a+1][b] == 4))) {
						if (go == true) {
							hulp = true;
							onder(32);
						}
					}
					if (a > 0) {
						if (nrboven == true && !((map[a-1][b] == 0) || (map[a-1][b] == 4))) {
							if (go == true) {
								hulp = true;
								boven();
							}
						}
					}
				}
			}
			
			if (map[a][b] == 5) {
				verplaatsenx = 0;
				verplaatseny = 0;
				System.out.println("einde");
			}
			y = y + verplaatseny*snelheid;
			x = x + verplaatsenx*snelheid;
		}  // kan simpeler

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
