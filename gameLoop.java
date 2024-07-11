import javax.swing.*;

public class gameLoop {
    public static void main(String[] args) {
        JFrame f= new JFrame("Game");
        f.setResizable(false);
        GamePanel game =new GamePanel();
        f.add(game);
        game.startGame();
        // f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1200,1000);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setLayout(null);
    }
}