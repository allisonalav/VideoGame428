
public class Warrior extends Sprite {
	
	static String [] pose = {"wr", "wl", "ir", "il", "ar", "al", "jr", "jl", "dr", "dl"};// this has to match the order with poses 
	
	
	public Warrior(int x, int y){
		//int w and int h will be taken out but if the warrior is too big add it 
		super("w", x, y, 90, 90, pose, 10, 3);

			
	}
}
