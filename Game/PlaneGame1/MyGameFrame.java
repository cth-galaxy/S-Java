package PlaneGame1;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author: CTH
 **/
public class MyGameFrame extends Frame {
    Image planeImg = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");

    Plane plane = new Plane(planeImg,300,600);
    //放炮弹容器
    ArrayList<Shell> shells = new ArrayList<>();
    //爆炸
    Explode explode;
    Date startTime = new Date();
    Date endTime;
    int time;
    /**
     * 初始化窗口
     */
    public void launchFrame() {
        this.setTitle("飞机躲避");
        this.setVisible(true);
        this.setLocation(600,150);
        this.setSize(700,700);
        //增加关闭窗口监听，这样用户点击右上角关闭图标，可以关闭游戏程序
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //多线程实现飞机运动
        class PaintThread implements Runnable {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    //延迟，模拟帧数
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //键盘控制飞机移动
        class keyMonitor extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                plane.addDirection(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                plane.minusDirection(e);
            }
        }

        new Thread(new PaintThread()).start();
        addKeyListener(new keyMonitor());
        //初始化窗口加载炮弹
        for (int i=0; i<50; i++) {
            shells.add(new Shell());
        }
    }

    /**
     * 重写窗口绘制
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(bg,0,0,null);
        plane.drawSelf(g);
        for (int i=0; i<shells.size(); i++) {
            shells.get(i).drawShell(g);
            //碰撞检测
            boolean flag = shells.get(i).getRect().intersects(plane.getRect());
            if (flag) {
                plane.live = false;
                if (explode == null) {
                    explode = new Explode(plane.x, plane.y);
                    endTime = new Date();
                }
                explode.draw(g);
            }
        }
        if (!plane.live) {
            time = (int)(endTime.getTime()-startTime.getTime())/1000;
            Color c = g.getColor();
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑", Font.BOLD, 50));
            g.drawString("时间："+time, 230,350);
            g.setColor(c);
        }
    }

    //主函数
    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
    //双缓冲解决闪烁问题
    private Image offScreenImage = null;

    public void update(Graphics g) {
        if(offScreenImage == null)
            offScreenImage = this.createImage(700,700);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
