import java.awt.*;
import javax.swing.*;

public class Bullet extends JPanel {
    int x;
    int y;
    int speed = 10;

    Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.yellow);
        g.fillRect(x, y, 5, 10);
    }

    public void update() {
        y -= speed;
    }

    public boolean isOutOfBounds() {
        return y < 0;
    }
}