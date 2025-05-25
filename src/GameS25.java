import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class GameS25 extends GameBase
{
	
	
	
	//size of the tiles  modify in paint for loop
	
//	ImageLayer tree = new ImageLayer("tree.png",0,0);
	Image [] tile = new Image [21];
	
	String [] map0 = {
			//ADD BLANK SPACES WITH  .......
			"LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL",
			"GHHHHHHHHHHHHHHHHHHHHHHHHHHHHHI",
			"...............................",
			"...............................",	
			"...AC..........................",
			".......AC......................",	
			"....................ABBBBTU....",	
			"...........AC.....P.KLLLM......",	
			"........AC......P...KLLLM......",	
			".....AC.............KLLLM......",	
			"ABBBBLMJJJABBBBBCJJJKLLLLBBBBC.",
		
			
	};
	String [] map1 = {
			//ADD BLANK SPACES WITH  .......
			"...............................",
			"...............................",
			"...............................",
			"...............B...............",	
			".............B.L.B.............",
			"...........B.L.L.L.B...........",	
			".........B.L.L.L.L.L.B.........",	
			".......B.L.L.L.L.L.L.L.B.......",	
			".....B.L.L.L.L.L.L.L.L.L.B.....",	
			"...B.L.L.L.L.L.L.L.L.L.L.L.B...",	
			"ABBBBBBBBBBBBBBBBBBBBBBBBBBBBBC",
			
			
	};
	
	String [] map2 = {
			//ADD BLANK SPACES WITH  .......
			"..............................",
			".H............................",
			"...H..........................",
			".....H........................",	
			".......H......P...............",
			"............P...P.............",	
			"..........P.......P...........",	
			"........P...........P.........",	
			"......P...............P.......",	
			"....P...................P.....",	
			"ABCJJJJJJJJJJJJJJJJJJJJJJJABBC",
			
			
	};		
	
	public void inGameLoop() 
	{
		
		Room.room[Room.current].inGameLoop();//this game loop refers to the room class so it does whatever is written in the class
		
	}
	
	
	public void paint(Graphics pen)
	{	
		
		
		this.setSize(1500, 550); // Set the applet window size
		//tree.draw(pen);
		
		Room.room[Room.current].draw(pen);
		

		
		
		//BACKGRROUNF tree.draw(pen);
		//houses.draw(pen);
		//trees.draw(pen);
		//r1.draw(pen); comment this out so the lines dont show	but warrior cant pass through it
		//r2.draw(pen);
//		
//		warrior.draw(pen);
//		bandit.draw(pen);
		

	}
	public void initialize() 
	{
		for(int i =0; i < tile.length; i++) {
			tile[i] = Toolkit.getDefaultToolkit().getImage("tile"+ (i+1)+ ".png");
		}
		
		//change the number when you add more blockers
		
		

		Rect[] r0_blocker = {
				new Rect(0,0, 10, 500),
				new Rect(1450,0,10,400),//last blocker at the end of the screen tall one 
				new Rect (0, 510 ,1500, 50),//base
				//new Rect (1400, 400, 100, 40),
				new Rect(250, 460, 100, 50),
				new Rect(400, 410, 100, 50),
				new Rect(550, 360, 100, 50),
				new Rect(350, 260, 100, 40),
				new Rect(150, 210, 100, 40),
				new Rect(800, 410, 50, 50),
				new Rect(900, 360, 50, 50),
				new Rect(1020, 310, 200, 250),
				new Rect(1250, 310, 100, 50)


				


			};

		Rect[] r1_blocker = {
				new Rect(0,0, 50, 300),
				new Rect(1400,0,50,300),
				new Rect (0, 500 ,1500, 50),//BASE
				new Rect(150, 460, 50, 100),
			    new Rect(250, 410, 50, 150),
			    new Rect(350, 360, 50, 200),
			    new Rect(450, 310, 50, 250),
			    new Rect(550, 260, 50, 300),
			    new Rect(650, 210, 50, 350),
			    new Rect(750, 160, 50, 350),
			    new Rect(850, 210, 50, 300),
			    new Rect(950, 260,  50, 250),
			    new Rect(1050, 310, 50, 200),
			    new Rect(1150, 360, 50, 150),
			    new Rect(1250, 410, 50, 100),
			    new Rect(1350, 460, 50, 50)
			};
		
		Rect[] r2_blocker = {
				new Rect(0,0, 50, 300),
				new Rect (0, 500 ,1500, 50),
				new Rect(200, 460, 50, 50),        // near base
				new Rect(300, 410, 50, 50),
				new Rect(400, 360, 50, 50),
			    new Rect(500, 310, 50, 50),
			    new Rect(600, 260, 50, 50),
			    new Rect(700, 210, 50, 50),        // peak
			    new Rect(800, 260, 50, 50),
			    new Rect(900, 310, 50, 50),
			    new Rect(1000, 360, 50, 50),
			    new Rect(1100, 410, 50, 50),
				new Rect(1200, 460, 50, 50),
			    new Rect(50, 60, 50, 10),  // top-left
			    new Rect(150, 110, 50, 10),
			    new Rect(250, 160, 50, 10),
			    new Rect(350, 210, 50, 10)
			};
	
		

		Coin[] coins0 = {
			    
			    new Coin(600, 450),
			    new Coin(180, 150),
			    new Coin(905, 300),
			    new Coin(385, 200),
			    new Coin(1290, 450)



			};
		
		Coin[] coins1 = {
				new Coin(155, 400),
				new Coin(255, 350),
				new Coin(355, 300),
				new Coin(455, 250),
				new Coin(555, 200),
				new Coin(655, 150),
				new Coin(755, 100),
				new Coin(855, 150),
				new Coin(955, 200),
				new Coin(1055, 250),
				new Coin(1155, 300),
				new Coin(1255, 350),
				new Coin(1355, 400)


			};

			Coin[] coins2 = {
				new Coin(205, 400),
				new Coin(505, 250),
				new Coin(705, 150),
				new Coin(1105, 350),
				new Coin(155, 50),
				new Coin(355, 150)

			};
		
		new Room(pressing, "forest.png", r0_blocker, map0, coins0);	
		new Room(pressing, "tree.png",   r1_blocker, map1, coins1);
		new Room(pressing, "swamp.jpg",  r2_blocker, map2, coins2);

		
	}

}