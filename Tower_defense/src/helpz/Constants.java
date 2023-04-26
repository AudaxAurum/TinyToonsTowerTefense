package helpz;

public class Constants {
	
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