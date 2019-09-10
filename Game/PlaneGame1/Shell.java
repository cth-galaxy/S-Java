package PlaneGame1;

import java.awt.*;

/**
 * @author: CTH
 **/
public class Shell extends GameObject {
    double degree;

    public Shell() {
        degree = Math.random()*Math.PI*2;//随意角度
        x = Math.random()*500;
        y = Math.random()*500;
        width = 10;
        height = 10;
        speed = 2;
    }


    public void drawShell(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillOval((int)x, (int)y, width, height);
        //炮弹沿着任意角度飞行
        x += speed*Math.cos(degree);
        y += speed*Math.sin(degree);

        //如下代码，用来实现碰到边界，炮弹反弹回来(原理和打台球游戏一样)
        if(y>700-height||y<30){
            degree = -degree;
        }
        if(x<0||x>700-width){
            degree = Math.PI-degree;
        }
        g.setColor(c);
    }
}
