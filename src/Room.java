import java.awt.*;
import java.awt.event.*;


public class Room extends RoomBase{	
	
	static int current = 0;
		
	static Room[] room = new Room[3];
	
	static int count = 0;
	
	static Warrior warrior = new Warrior(20, 400);

	Image background;
	
	int number;
	
	Rect[] blocker; 

	final int size = 50;
	
	//Change tile number if adding more tiles 
	Image [] tile = new Image [21];
	
	String[] map;
	
	Rect winZone;
	static boolean youWin = false;

	Coin[] coins;
	static int score = 0;
	
	public static int coinCount = 0;



	
	
	public Room(boolean[] pressing, String filename, Rect[] blocker, String [] map, Coin[] coins) {
		
		super(pressing);

		background = Toolkit.getDefaultToolkit().getImage(filename);
		
		this.blocker = blocker;
		
		if (count == 2) { // Room 2
		    winZone = new Rect(1400, 0, 100, 500); 
		}


		this.map = map;
		
		this.coins = coins;
		
		for (int i = 0; i < tile.length; i++) {
			tile[i] = Toolkit.getDefaultToolkit().getImage("tile" + (i + 1) + ".png");
		}
		
		room[count] = this;
		
		number = count;
		
		count++;
		
	}
	
	public void setRoom(int num) {
		
		this.current = num;
	}
	

	public void inGameLoop() {
	    boolean moved = false;
		//this dont move him it jsut makes the animation keep going once the key is pressed 
	    if (pressing[LT]){
			
			warrior.goLeft(5);		moved = true;
			
		}
		
		if (pressing[RT]){
			
			warrior.goRight(5);		moved = true;
			
		}
		
		if(pressing[SPACE]) {
			warrior.jump();
		}
				
		if (pressing[_A]){
			
			if (warrior.facingRight) warrior.attackRight();  
	        else warrior.attackLeft();
	        moved = true;
	        
		}		
		
		 if (!moved){		 
			
			if (warrior.facingRight) warrior.idleRight();  
			else warrior.idleLeft();
			 
	    }
		// this makes it work as before so moving it around the screen 
		warrior.move();

		//if (pressing[SPACE]) warrior.jump'
		
		for(int i =0; i < blocker.length; i++) {
			
			if(warrior.overlaps(blocker[i])) {
				warrior.vy = 0;
				warrior.pushedOutOf(blocker[i]);
				warrior.vx = 0;
//				warrior.vy = 0;
				
			}
	
		}
		
		
		if(warrior.x < -20) 
		{
			setRoom(number - 1);
			
			warrior.x = 1500;
		
	}
	
		if(warrior.x > 1500) 
		{
			setRoom (number + 1);
			
			warrior.x = -20;
			
		}
		if (current == 2 && winZone != null && warrior.overlaps(winZone)) {
		    youWin = true;
		}

		for (int i = 0; i < coins.length; i++) {
		    if (!coins[i].collected && warrior.overlaps(coins[i])) {
		        coins[i].collected = true;
		        coinCount++; 
		    }
		}

		
		
		}
	
	
	
	
	public void draw(Graphics pen) {
		
		pen.drawImage(background,0,0,1920, 550,null);
		
		for(int i =0; i < map.length; i++) {
			for(int j = 0; j < map[i].length(); j++) {
				char c =map[i].charAt(j);
				// horizontal drawing if(c == 'A') pen.drawImage(tile[0], j*size, i*size, size, size, null);
				// vertical drwaing   if(c == 'A') pen.drawImage(tile[0], i*size, j*size, size, size, null);
				// just change the i and j around
				if(c == 'A') pen.drawImage(tile[0],  j*size, i*size, size, size, null);
				if(c == 'B') pen.drawImage(tile[1],  j*size, i*size, size, size, null);
				if(c == 'C') pen.drawImage(tile[2],  j*size, i*size, size, size, null);
				if(c == 'D') pen.drawImage(tile[3],  j*size, i*size, size, size, null);
				if(c == 'E') pen.drawImage(tile[4],  j*size, i*size, size, size, null);
				if(c == 'F') pen.drawImage(tile[5],  j*size, i*size, size, size, null);
				if(c == 'G') pen.drawImage(tile[6],  j*size, i*size, size, size, null);
				if(c == 'H') pen.drawImage(tile[7],  j*size, i*size, size, size, null);
				if(c == 'I') pen.drawImage(tile[8],  j*size, i*size, size, size, null);
				if(c == 'J') pen.drawImage(tile[9],  j*size, i*size, size, size, null);
				if(c == 'K') pen.drawImage(tile[10], j*size, i*size, size, size, null);
				if(c == 'L') pen.drawImage(tile[11], j*size, i*size, size, size, null);
				if(c == 'M') pen.drawImage(tile[12], j*size, i*size, size, size, null);
				if(c == 'N') pen.drawImage(tile[13], j*size, i*size, size, size, null);
				if(c == 'O') pen.drawImage(tile[14], j*size, i*size, size, size, null);
				if(c == 'P') pen.drawImage(tile[15], j*size, i*size, size, size, null);
				if(c == 'Q') pen.drawImage(tile[16], j*size, i*size, size, size, null);
				if(c == 'R') pen.drawImage(tile[17], j*size, i*size, size, size, null);
				if(c == 'S') pen.drawImage(tile[18], j*size, i*size, size, size, null);
				if(c == 'T') pen.drawImage(tile[19], j*size, i*size, size, size, null);
				if(c == 'U') pen.drawImage(tile[20], j*size, i*size, size, size, null);
				if(c == 'V') pen.drawImage(tile[21], j*size, i*size, size, size, null);
			}
		
		}
		warrior.draw(pen);
		
		for (int i = 0; i < blocker.length; i++) {
		    if (blocker[i] != null) {
		        //blocker[i].draw(pen);
		    }
		}
		if (current == 2 && winZone != null && warrior.overlaps(winZone)) {
		    pen.setColor(Color.YELLOW);
		    pen.setFont(new Font("Arial", Font.BOLD, 48));
		    pen.drawString("YOU WIN!", 600, 300);
		}
		
		for (int i = 0; i < coins.length; i++) {
		    coins[i].draw(pen);
		}
	
		pen.setFont(new Font("Arial", Font.BOLD, 24));
		pen.drawString("Coins: " + coinCount, 30, 50); 



	}
		
	

}
