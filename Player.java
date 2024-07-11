import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Player extends JPanel{
    int x=600;
    int y=900;
    int speed = 7;
    int directionX = 0;
    int directionY = 0;
    Image image;
    ArrayList<Bullet> bullets;

    Player(){
        try {
            image=ImageIO.read(new File("./ship_1.png"));
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
        bullets =new ArrayList<>();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.drawImage(image,x, y, 50, 50,this);
        for (Bullet bullet : bullets) {
            bullet.paintComponent(g);
        }
    }

    public void playerUpdate(KeyEvent e){
        int code = e.getKeyCode();
        if(code == 37){       //left
            directionX = -1;
        }
        else if (code == 39){  //right
            directionX = 1;
        }
        else if (code == 38){   //up
            directionY = -1;
        }
        else if (code == 40){    //down
            directionY = 1;
        }
        else if(code==32){  //bullet fire
             shoot();
        }
    }

    public void move(){
        int nextX = x + directionX * speed;
        int nextY = y + directionY * speed;

            if (nextX >= 0 && nextX <= 1100) {
                x = nextX;
            }
            if (nextY >= 0 && nextY <= 900) {
                y = nextY;
            }
    
    }

    public void stop(){
        directionX = 0;
        directionY = 0;
    }

    public void shoot(){
        bullets.add(new Bullet(x+23,y));
    }

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }
}
