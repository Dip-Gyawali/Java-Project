import java.awt.*;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Enemy extends JPanel{
    Random randomNumber = new Random();
    int x=randomNumber.nextInt(1200);
    int y=randomNumber.nextInt(900)-910;
    Image image;

    Enemy(){
        try{
           image=ImageIO.read(new File("./Asteroid Brown.png"));
        }
        catch(Exception e){
             System.out.println("Exception Handle");
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.drawImage(image,x, y, 50, 50,this);
    }

    public void update(){
        y+=1;

        if(y>1300){
            y=randomNumber.nextInt(900)-910;
            x=randomNumber.nextInt(1200);
        }
    }
}
