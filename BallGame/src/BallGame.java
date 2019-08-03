import javax.swing.*;
import java.awt.*;

public class BallGame extends JFrame {
    double x = 100;
    double y = 100;
    boolean right = true;

    //加载图片
    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    public void paint(Graphics g) {
        System.out.println("窗口被画一次");
        g.drawImage(desk, 0, 0, null);
        g.drawImage(ball, (int) x, (int) y, null);

        if (right) {
            x = x + 1;
        } else {
            x = x - 1;
        }

        if (x > 840) {
            right = false;
        }
        if (x < 10) {
            right = true;
        }
    }

    //加载窗口
    void launchFrame() {
        setSize(856, 600);
        setLocation(300, 100);
        setVisible(true);

        //重画窗口
        while (true) {
            repaint();
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

        public static void main (String[]args){
            BallGame game = new BallGame();
            game.launchFrame();

        }
    }

