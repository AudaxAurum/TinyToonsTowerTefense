package helpz;

public class Constants {
	
	public static final int DimSprite = 64;
	public static final int xMatrix = 16;
	public static final int yMatrix = 9;
	public static final int xScherm = xMatrix*64;
	public static final int yScherm = yMatrix*64;
	
	public static class Projectiles{
		
		public static final int ARROW = 0;
		

		
		public static float GetSpeed(int type) {
			switch (type) {
			case ARROW:
				return 3f;
			}
			
			return 0f;
		}
	}
	
	public static class Towers{
		public static final int UNBUILD = 0;
		public static final int ARCHER = 1;
//		public static final int 
//		public static final int 

	}
	
	public static class Enemies {
		
		public static final int ORC = 3;
		public static final int GOBLIN = 4;
		public static final int idk = 5;

		public static int GetReward(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 5;
			case GOBLIN:
				return 5;
			}
			return 0;
		}

		public static float GetSpeed(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 0.5f;
			case GOBLIN:
				return 0.7f;

			}
			return 0;
		}

		public static int GetStartHealth(int enemyType) {
			switch (enemyType) {
			case ORC:
				return 85;
			case GOBLIN:
				return 100;
			}
			return 0;
		}
	}
}