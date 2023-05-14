package helpz;

import maplayers.MapLayer1;

public class Constants {
	
	public static final int DimSprite = 64;
	public static final int xMatrix = 16;
	public static final int yMatrix = 9;
	public static final int xScherm = xMatrix*64;
	public static final int yScherm = yMatrix*64;
	
	public static class Projectiles{
		
		public static final int ARROW = 0;
		public static final int BOMB = 1;
			
		public static float GetSpeed(int type) {
			switch (type) {
			case ARROW:
				return 3f;
			case BOMB:
				return 2f;
			}
			
			return 0f;
		}
		public static float GetImpactRange(int type) {
			switch (type) {
			case ARROW:
				return 5f;
			case BOMB:
				return 64f;
			}
			
			return 0f;
		}
	}
	
	public static class Tiles{
		public static final int BUILDABLE = 0;
		public static final int UNBUILDABLE = 1;
	}
	
	public static class Towers{
		public static final int UNBUILD = 0;
		public static final int ARCHER0 = 10;
		public static final int ARCHER1 = 11;
		public static final int ARCHER2 = 12;
//		public static final int WIZARD0 = 20;
//		public static final int WIZARD1 = 21;
		public static final int CRUSHER0 = 13;
		public static final int CRUSHER1 = 14;
		public static final int CRUSHER2 = 15;
		
		public static int GetProjectile(int towerType) {
			switch (towerType) {
			case ARCHER0:
				return 0;
			
			case UNBUILD:
				return 0;

			}

			return 0;
		}
		
		public static float GetStartDmg(int towerType) {
			switch (towerType) {
			case ARCHER0:
				return 15;
			
			case CRUSHER0:
				
				return 5;
			
			case UNBUILD:
				return 0;

			}

			return 0;
		}

		public static float GetDefaultRange(int towerType) {
			switch (towerType) {
			case ARCHER0:
				return 240;
				
			case CRUSHER0:
				return 200;
			
			case UNBUILD:
				return 0;
			}
			return 0;
		}

		public static float GetDefaultCooldown(int towerType) {
			switch (towerType) {

			case ARCHER0:
				return 35;
			
			case CRUSHER0:
				
				return 50;
			
			case UNBUILD:
				return 0;
			}

			return 0;
		}
		public static int Getprice(int towerType) {
			switch (towerType) {
			case ARCHER0:
				return 75;
				
			case CRUSHER0:
				
				return 50;
			
			case UNBUILD:
				return 0;

			}

			return 0;
		}
		public static float GetRangeUpgradeFactor(int towerType) {
			switch (towerType) {
			case ARCHER0:
				return 1.5f;
				
			case ARCHER1:
				return 3;
			
			case ARCHER2:
				return 0.75f;
			
			case UNBUILD:
				return 0;

			}
			return 0;
		}
		public static float GetDmgUpgradeFactor(int towerType) {
			switch (towerType) {
			case ARCHER0:
				return 1;
				
			case ARCHER1:
				return 1.5f;
			
			case ARCHER2:
				return 0.5f;
				
			case UNBUILD:
				return 0;

			}

			return 0;
		}
		public static float GetUpgradePriceFactor(int towerType) {
			switch (towerType) {
			case ARCHER0:
				return 1.5f;
				
			case ARCHER1:
				return 1.7f;
			
			case ARCHER2:
				return 1.4f;
				
			case UNBUILD:
				return 0;

			}

			return 0;
		}
	}
	public static class Enemies {
		
		public static final int ORC = 3;
		public static final int GOBLIN = 4;
		public static final int BOMBER = 5;

		public static int GetReward(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 10;
			case GOBLIN:
				return 5;
			case BOMBER:
				return 7;
			}
			return 0;
		}

		public static float GetSpeed(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 0.5f;
			case GOBLIN:
				return 0.7f;
			case BOMBER:
				return 1f;

			}
			return 0;
		}

		public static int GetStartHealth(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 100;
			case GOBLIN:
				return 85;
			case BOMBER:
				return 75;
			}
			return 0;
		}
		public static int GetSprite(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 6;
			case GOBLIN:
				return 0;
			case BOMBER:
				return 3;
			}
			return 0;
		}
		public static int Getdmg(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 2;
			case GOBLIN:
				return 1;
			case BOMBER:
				return 1;
			}
			return 0;
		}
	}
		public static int GetRange(float x1, float y1, float x2, float y2) {
			
			float xDiff  = Math.abs(x1 - x2);
			float yDiff = Math.abs(y1 - y2);
			
			return (int) Math.hypot(xDiff, yDiff);
			
		}
		public static class levels	{
			public static final int LEVEL1 = 0;
			public static final int LEVEL2 = 1;
			public static final int LEVEL3 = 2;
			public static final int LEVEL4 = 3;
			
			public static int[][] GetMap(int level) {
				switch(level) {
				case LEVEL1:
					return MapLayer1.Level1;
			   
				case LEVEL2:
					return MapLayer1.Level0;
		    		
		    	}
				return MapLayer1.Level0;
			}
			public static int GetCastleHealth(int level) {
				switch(level) {
				case LEVEL1:
					return 20;
					
				}
				return 0;
			}
			public static int GetStartGold(int level) {
				switch(level) {
				case LEVEL1:
					return 200;
				}
				return 0;
			}
			public static int getAmountOfWaves(int level) {
				switch(level) {
				case LEVEL1:
					return 5  ;
				}
				return 0;
			}
		}
	}

