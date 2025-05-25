import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public abstract class GameBase extends Applet implements Runnable, KeyListener
{
	
	Image offScreen;
	Graphics offScreen_pen;
	
	
//	Rect r1 = new Rect(10, 10, 40, 1000);
//	Rect r2 = new Rect(10, 700, 1800, 40);
//	
//	
//	//BACKGROUND
//	//ImageLayer tree = new ImageLayer("tree.png",0,0, 0);
//	
//	
//	//ImageLayer houses = new ImageLayer("houses.png",0,0, 0 );
//	//ImageLayer trees = new ImageLayer("trees.png",0,0,0);
//	
//
//	Warrior warrior = new Warrior(200, 700);
//	Bandit bandit = new Bandit (600,700);//width height
//	
//	
//	int mx = 2000;
//	int my = 20;
	
	Thread t;
	
	
	boolean [] pressing = new boolean[100];
	

	public abstract void initialize();
	
	public void init()
	{
		
		

		offScreen = this.createImage(1920, 1080);
		offScreen_pen = offScreen.getGraphics();
		
		initialize();
		
		addKeyListener(this);
		requestFocus();

		t = new Thread(this);
		t.start();
	}
	
	
	public abstract void inGameLoop();
	
	public void run()
	{
		while (true) {
			
			
			inGameLoop();
			
			
			
//			//moving mountains if the warrior goes to the right the background must go to the left
//			//moving background
////			if (LT_pressed)  mountains.moveRight(4);
////			if (RT_pressed)  mountains.moveLeft(4);
////			if (LT_pressed)  trees.moveRight(4);
////			if (RT_pressed)  trees.moveLeft(4);
////			if (LT_pressed)  houses.moveRight(4);
////			if (RT_pressed)  houses.moveLeft(4);
//			
//			if (UP_pressed)  warrior.moveUp(4);
//			if (DN_pressed)  warrior.moveDown(4);
//			if (LT_pressed)  warrior.moveLeft(4);
//			if (RT_pressed)  warrior.moveRight(4);
//
//			if (warrior.overlaps(r1)) {
//				if (warrior.cameFromLeft())  warrior.pushBy(-4, 0);
//				if (warrior.cameFromRight()) warrior.pushBy(4, 0);
//				if (warrior.cameFromAbove()) warrior.pushBy(0, 4);
//				if (warrior.cameFromBelow()) warrior.pushBy(0, -4);
//			}
//
//			if (warrior.overlaps(r2)) {
//				if (warrior.cameFromLeft())  warrior.pushBy(-4, 0);
//				if (warrior.cameFromRight()) warrior.pushBy(4, 0);
//				if (warrior.cameFromAbove()) warrior.pushBy(0, 4);
//				if (warrior.cameFromBelow()) warrior.pushBy(0, -4);
//			}

			repaint(); // request screen redraw

			try {
				t.sleep(16); 
			} catch (Exception x) {
				
			}
		}
	}

	

	public void update (Graphics pen) {
		offScreen_pen.clearRect(0, 0, 1920,1080 );
		paint(offScreen_pen);
		
		pen.drawImage(offScreen, 0, 0, null);
	}
	
	
	
	
	public void keyPressed(KeyEvent e)
	{
		// DO NOT EVER MOVE ANYTHING IN THE KEYLISTENER CODE
		// ALL MOVEMENT MUST BE DONE IN THE GAME LOOP
		
		pressing [e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e)
	{
		pressing [e.getKeyCode()] = false;
	}
	
	public void keyTyped(KeyEvent e) {}
}
	


