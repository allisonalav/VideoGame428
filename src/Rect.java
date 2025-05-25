import java.awt.Graphics;

public class Rect
{
	int x;
	int y;
	
	int w;
	int h;
	
	double vx = 5;//give velocity to the right
	double vy = 0; //make it go up 
	
	static double G = .8; //make it go down 
	
	int old_x;
	int old_y;
	
	public Rect(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		
		this.w = w;
		this.h = h;
		
//		int old_x = x;
//		int old_y = y;
		
		
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	
	public void chase(Rect r)
	{
		if(x > r.x)  x -= 2;
		if(x < r.x)  x += 2;
		if(y > r.y)  y -= 2;
		if(y < r.y)  y += 2;
	}
	
	public void evade(Rect r)
	{
		if(x > r.x)  x += 2;
		if(x < r.x)  x -= 2;
		if(y > r.y)  y += 2;
		if(y < r.y)  y -= 2;
	
	}
	
//	public void moveBy(int dx, int dy)
//	{
//		old_x = x;
//		old_y = y;
//		
//		x += dx;
//		y += dy;
//	}
//	
	public void goUp(int vy)
	{
		this.vy = -vy;		
	}
	
	public void goDown(int vy)
	{
		this.vy = +vy;		
	}
	
	public void goLeft(int vx)
	{
		this.vx = -vx;
	}
	
	public void goRight(int vx)
	{
		this.vx = +vx;	
	}
	
	public void jump() {
		vy = -10;
		
	}
	
	
	public void move() 
	{
		//velocity
		x += vx;
		y += vy;
		
		
		//stop sliding after moving
		vy += G;
		
	}
	
	
	
	public void pushBy(int dx, int dy)
	{
		x += dx;
		y += dy;		
	}
	
	public void resizeBy(int dw, int dh)
	{
		w += dw;
		h += dh;
	}
	
	public boolean overlaps(Rect r)
	{
		return (r.y <=   y +   h) &&
			   (  y <= r.y + r.h) &&
			   (r.x <=   x +   w) &&
			   (  x <= r.x + r.w);
	}
	
	public void pushedOutOf(Rect r)
	{
		int dxLeft   = (r.x + r.w) - x;      // right side of r to left side of this
		int dxRight  = (x + w) - r.x;        // left side of r to right side of this
		int dyTop    = (r.y + r.h) - y;
		int dyBottom = (y + h) - r.y;

		int minX = Math.min(dxLeft, dxRight);
		int minY = Math.min(dyTop, dyBottom);

		if (minX < minY) {
			// Resolve horizontal overlap
			if (dxLeft < dxRight) {
				// Came from left side
				pushbackRightFrom(r);
			} else {
				// Came from right side
				pushbackLeftFrom(r);
			}
			vx = 0;
		} else {
			// Resolve vertical overlap
			if (dyTop < dyBottom) {
				// Came from top
				pushbackDownFrom(r);
			} else {
				// Came from bottom
				pushbackUpFrom(r);
			}
			vy = 0;
		}
	}

	
	public boolean cameFromLeftOf(Rect r)
	{
		return x - vx + w < r.x;
	}
	
	public boolean cameFromRightOf(Rect r)
	{
		return r.x + r.w < x - vx;
	}
	
	public boolean cameFromAbove(Rect r)
	{
		return y - vy + h < r.y;
	}
	
	public boolean cameFromBelow(Rect r)
	{
		return r.y + r.h < y - vy;
	}
	
	public void pushbackLeftFrom(Rect r)
	{
		x = r.x - w - 1;
	}
	
	public void pushbackRightFrom(Rect r)
	{
		x = r.x + r.w + 1;
	}
	
	public void pushbackUpFrom(Rect r)
	{
		y = r.y - h - 1;
	}
	
	public void pushbackDownFrom(Rect r)
	{
		y = r.y + r.h + 1;
	}
//	
//
//	
//	
	public boolean contains(int mx, int my)
	{
		return (mx > x  ) && 
			   (mx < x+w) && 
			   (my > y  ) && 
			   (my < y+h);  
	}
	
	public void draw(Graphics pen)
	{
		pen.drawRect(x,  y,  w,  h);
	}
	

}