import java.awt.*;

public class Sprite extends Rect {
	
	Animation [] animation;
	
	boolean moving = false;
	
	final int WR = 0;
	final int WL = 1;
	final int IR = 2;
	final int IL = 3;
	final int AR = 4;
	final int AL = 5;
	final int JR = 6;
	final int JL = 7;
	
	
	int pose = IR;
	
	int previousPose = -1;

    public boolean facingRight = true;

    //public boolean inAir = false;



	
	public Sprite(String name, int x, int y, int w, int h, String[] pose, int count, int duration){
		//name represents the name of the sprite which is w and then pose is walk attack wtc 
		//duration is how long the image stays in the screen 
		
		super(x,y,w,h);
		
		animation = new Animation[pose.length];
		
		for(int i = 0; i < pose.length; i++ )

		animation[i] = new Animation(name + "_" + pose[i], count, duration );
		
		
	}
	
	public void draw(Graphics pen) {
		
		if (pose != previousPose) {
	        animation[pose].reset();
	    }

	    pen.drawImage(animation[pose].nextImage(), x, y, w, h, null);

	    previousPose = pose;
	    moving = false;
	
	}
	
	public void goRight(int dx)
	{
		super.goRight(dx);

		pose = WR;
	
		moving = true;
		
		facingRight = true;

	}
	
	public void goLeft(int dx)
	{
		super.goLeft(dx);
		
		pose = WL;
		
		moving = true;

		
		facingRight = false;

	}
	
	public void move() {
		
		super.move();
				
	}
	
	public void idleRight() {
		
		pose = IR;
	}
	
	public void idleLeft() {
	    
		pose = IL;
	}

	public void attackRight() {
	    
	    moving = true;
	    
	    pose = AR;
	}

	public void attackLeft() {
	   
		moving = true;
		
	    pose = AL;
	}
	
	
	public void jump() {
	    
		if (facingRight) {
	    
			moving = true;
			pose = JR;
	    
		} else {
	      
			moving = true;

			pose = JL;
	    }
		
	    vy = -6; 
	}
	
	
	
}
