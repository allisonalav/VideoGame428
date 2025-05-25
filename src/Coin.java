import java.awt.*;

public class Coin extends Rect {
    Image image;
    boolean collected = false;

    public Coin(int x, int y) {
        super(x, y, 40, 40); // Adjust size as needed
        image = Toolkit.getDefaultToolkit().getImage("coin.png");
    }

    public void draw(Graphics pen) {
        if (!collected) {
            pen.drawImage(image, x, y, w, h, null);
        }
    }
}
