package objects;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class EnemyMovement {

	final int PANEL_WIDTH = 512;   //deze 2 aanapssen aan werkelijke grote
	final int PANEL_HEIGHT = 288;
	Image enemy;
	Image backgroundImage; //voor de achtergrond
	Timer timer;
	int a = 0;   //a en b voor de het pad in de map af te lopen
	int b = 3;
	int x = b*32 + 16;
	int y = a*32;
	int snelheid = 1;
	int verplaatsenx = 0;
	int verplaatseny = 0;
	int nrboven = 0;
	int nronder = 1;
	int nrrechts = 1;
	int nrlinks = 1;
	int hulp = 0;
	int go = 0;
	int[][] map = {
            //0: gras, 1: rechte baan, 2: bocht, 3: kruispunt, 4: torenplek, 5: poort kasteel
            {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,0,0,0,5,0,0,0,2,1,2,0},
            {0,2,1,2,0,0,0,0,1,0,0,0,1,4,1,0},
            {0,1,0,0,0,0,0,0,2,1,1,1,3,1,2,0},
            {0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0},
            {0,1,0,0,2,1,1,1,1,1,1,1,3,1,2,0},
            {0,1,0,0,1,0,0,0,0,0,0,0,1,4,1,0},
            {0,2,1,1,2,0,0,0,0,0,0,0,2,1,2,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}

    };
	
	void onder(int hoeveel) {
		verplaatsenx = 0;
		verplaatseny = 0;
		if (y < a*32 + hoeveel) {
			verplaatseny = 1;
			go = 0;
		} 
		else {
			go = 1;
			if (hulp == 1) {
				a = a + 1;
			}
			nrboven = 0;
			nronder = 1;
			nrrechts = 1;
			nrlinks = 1;
			verplaatseny = 0;
		}
	}
	void boven(int hoeveel) {
		verplaatsenx = 0;
		verplaatseny = 0;
		if (y > a*32) {
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
	void rechts(int hoeveel) {
		verplaatsenx = 0;
		verplaatseny = 0;
		if (x < b*32 + hoeveel) {
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
	void links(int hoeveel) {
		verplaatsenx = 0;
		verplaatseny = 0;
		if (x > b*32) {
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if (map[a][b] == 1 || map[a][b] == 3) {
			if (!(nronder == 0) && !((map[a+1][b] == 0) || (map[a+1][b] == 4)) && nrboven == 0) {
				hulp = 1;
				onder(32);
			}
			if (a > 0) {
			if (!(nrboven == 0) && !((map[a-1][b] == 0) || (map[a-1][b] == 4)) && nronder == 0) {
				hulp = 1;
				boven(32);
			}}
			if (!(nrrechts == 0) && !((map[a][b+1] == 0) || (map[a][b+1] == 4)) && nrlinks == 0) {
				hulp = 1;
				rechts(32);
			}
			if (b > 0) {
			if (!(nrlinks == 0) && !((map[a][b-1] == 0) || (map[a][b-1] == 4)) && nrrechts == 0) {
				hulp = 1;
				links(32);
			}}
		}
		if (map[a][b] == 2) {
			if (!(nrrechts == 0) && !((map[a][b+1] == 0) || (map[a][b+1] == 4)) && nrboven == 0) {
				hulp = 0;
				onder(16);
				if (go == 1) {
					hulp = 1;
					rechts(16);
				}
				
			}
			if (b > 0) {
			if (!(nrlinks == 0) && !((map[a][b-1] == 0) || (map[a][b-1] == 4)) && nronder == 0) {
				hulp = 0;
				boven(16);
				if (go == 1) {
					hulp = 1;
					links(16);
				}
			}}
			if (a > 0) {
			if (!(nrboven == 0) && !((map[a-1][b] == 0) || (map[a-1][b] == 4)) && nrlinks == 0) {
				hulp = 0;
				rechts(16);
				if (go == 1) {
					hulp = 1;
					boven(16);
				}
			}}
			if (!(nronder == 0) && !((map[a+1][b] == 0) || (map[a+1][b] == 4)) && nrrechts == 0) {
				hulp = 0;
				links(16);
				if (go == 1) {
					hulp = 1;
					onder(16);
				}
			}
			if (b > 0) {
			if (!(nrlinks == 0) && !((map[a][b-1] == 0) || (map[a][b-1] == 4)) && nrboven == 0) {
				hulp = 0;
				onder(16);
				if (go == 1) {
					hulp = 1;
					links(16);
				}
			}}
			if (!(nrrechts == 0) && !((map[a][b+1] == 0) || (map[a][b+1] == 4)) && nronder == 0) {
				hulp = 0;
				boven(16);
				if (go == 1) {
					hulp = 1;
					rechts(16);
				}
			}
			if (!(nronder == 0) && !((map[a+1][b] == 0) || (map[a+1][b] == 4)) && nrlinks == 0) {
				hulp = 0;
				rechts(16);
				if (go == 1) {
					hulp = 1;
					onder(16);	
				}
			}
			if (a > 0) {
			if (!(nrboven == 0) && !((map[a-1][b] == 0) || (map[a-1][b] == 4)) && nrrechts == 0) {
				hulp = 0;
				links(16);
				if (go == 1) {
					hulp = 1;
					boven(16);
				}
			}}
		}
		if (map[a][b] == 5) {
			verplaatsenx = 0;
			verplaatseny = 0;
		}
		y = y + verplaatseny*snelheid;
		x = x + verplaatsenx*snelheid;
		repaint();
	}
}