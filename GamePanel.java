import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    Thread thread;
    Enemy[] enemies = new Enemy[5];
    Player player = new Player();
    Image image;

    GamePanel() {
        super();
        this.setPreferredSize(new Dimension(1200, 1000));
        for (int i = 0; i < enemies.length; i++) {
            enemies[i] = new Enemy();
        }
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {;
                player.playerUpdate(e);
            }

            public void keyReleased(KeyEvent e) {
                player.stop();
            }

        });

        try {
            image=ImageIO.read(new File("./back_3.png"));
        } catch (Exception e) {
            System.out.println("Error Occured");
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, 1200, 1000, this);
        }

        player.paintComponent(g);
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].paintComponent(g);
        }
    }

    public void startGame() {
        thread = new Thread(this);
        thread.start();
    }

    public void update() {
        for(int i = 0; i < enemies.length; i++) {
            enemies[i].update();
        }
        player.move();
        ArrayList<Bullet> bullets = player.getBullets();
           Iterator<Bullet> iterator = bullets.iterator();
           while (iterator.hasNext()) {
               Bullet bullet = iterator.next();
               bullet.update();
               if (bullet.isOutOfBounds()) {
                   iterator.remove();
               }
           }
    }


    @Override
    public void run() {
        double drawInterval = 1000000000 / 60;
        double deltaTime = 0;
        long lastPassedTime = System.nanoTime();
        long currentTime = 0;
        while (thread != null) {
            // long time = System.nanoTime();
            // System.out.println("Game Loop" + time);
            // x+=1;
            currentTime = System.nanoTime();
            deltaTime += (currentTime - lastPassedTime) / drawInterval;
            lastPassedTime = currentTime;

            if (deltaTime >= 1) {
                update();
                repaint();
                deltaTime--;
            }
        }
    }
}
