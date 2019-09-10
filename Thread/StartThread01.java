package Thread;

/**
 * 实现Runable方法实现多线程
 * @author: CTH
 **/
public class StartThread01 implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println("玩游戏");
        }
    }

    public static void main(String[] args) {
        StartThread01 st1 = new StartThread01();
        Thread t = new Thread(st1);//代理对象
        t.start();//只有thead类有stat方法，借助thred实现
        for (int i=0; i<100; i++) {
            System.out.println("吃饭");
        }
    }
}
