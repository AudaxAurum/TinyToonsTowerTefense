package helpz;

public class Constants {
	
	public static final int DimSprite = 64;
	
	public static final int xMatrix = 16;
	public static final int yMatrix = 9;
	
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
}