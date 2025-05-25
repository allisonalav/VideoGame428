package copy;


//dont use this if not scrolling
public class Camera {

	static int x;
	static int y;
	
	public void setLocation(int x, int y) {
		Camera.x = x;
		Camera.y = y;
	
	}
	
	public static void moveLeft(int dx) {
		 
		
		x -= dx;
		
	}
	
	public static void moveRigth(int dx) {
		 
		
		x += dx;
		
	}
	
	
}
