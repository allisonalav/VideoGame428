package copy;
import java.awt.*;

public class ImageLayer {

	Image image;
	
	private int x;
	private int y;
//	private int z ;
	
	
	public ImageLayer(String name, int x, int y) {
		
		image = Toolkit.getDefaultToolkit().getImage(name);
		
		this.x = x;
		this.y = y;
//		this.z= z;
		
	}
	

	
	public void draw(Graphics pen) {
		
		//this is so mountains are draw 10 times in the game 
		for(int i = 0; i < 10; i++) {
		pen.drawImage(image, x + 576 * i, y, 576, 550, null);
		}
		
	}
	
	
}
