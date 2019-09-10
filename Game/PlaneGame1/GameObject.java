package PlaneGame1;

import java.awt.*;

/**
 * @author: CTH
 **/
public class GameObject {
    Image img;//物体对应图片
    double x,y;//物体坐标
    int speed;//物体运行速度
    int width,height;//物体大小（对应矩形区域）

    /**
     * 画图像
     * @param g
     */
    public void drawSelf(Graphics g) {
        g.drawImage(img, (int)x, (int)y, null);
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public GameObject() {

    }

    public Rectangle getRect() {
        return new Rectangle((int)x, (int)y, width, height);
    }
}
