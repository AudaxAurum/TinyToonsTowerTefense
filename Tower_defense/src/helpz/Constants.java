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
}