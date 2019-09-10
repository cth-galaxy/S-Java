package Thread.Syn;

/**
 *
 * 相互持有对方的锁，造成死锁
 * 避免：不在同一个代码块中持有多个对象的锁
 * @author: CTH
 **/
public class TestBlock {
    public static void main(String[] args) {
        new Thread(new Girl(0,"张柏芝")).start();
        new Thread(new Girl(1,"王菲")).start();
    }
}
class Lipstick{
}
class Mirror{
}
class Girl implements Runnable {
    int choice;
    String name;

    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    public Girl(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        makeUp();
    }
    public void makeUp() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.name + "涂口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror) {//1秒后想拥有镜子
                    System.out.println(this.name + "照镜子");
                }
            }
        }else {
            synchronized (mirror) {
                System.out.println(this.name + "照镜子");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick) {//2秒后想拥有口红
                    System.out.println(this.name + "涂口红");
                }
            }
        }
    }
}
