import java.awt.*;

public class Animation {

	Image[] image;

	int current = 0;
	
	int duration;//how long you want the image on the screen before switching 
	int delay;
	
	public Animation(String name, int count, int duration ) {// name here is the animation w_w which is warrior walk
		image = new Image[count];
		
		for(int i =0; i<count;i++) {
			
			image[i] = Toolkit.getDefaultToolkit().getImage(name + "_"+ i + ".png");
		
		}
		
		this.duration = duration;
		this.delay = duration;
		
	}//for loading the image 
	
	public Image nextImage() {// gets called 60 times per second 
		
//		
//		    delay--;
//		    if (delay <= 0) {
//		        current++;
//		        if (current >= image.length) current = 0;
//		        delay = duration; // reset delay every time we change frame
//		    }
//		    return image[current];
		

		
		delay--;
        if (delay <= 0) {
            current++;
            if (current >= image.length) {
                current = 0;
            }
            delay = duration;
        }
        return image[current];
		
	}
	
	public Image stillImage() {
		return image[0];
	}
	
	public boolean isLastFrame() {
	    return current == image.length - 1;
	}

	public void reset() {
	    current = 0;
	}

	
	public void draw(Graphics pen) {
		pen.drawImage(image[current], 0,0,100,200,null);
	}
	
	
	
}
