package Thread;

/**
 * Daemon守护线程。系统会等待用户线程执行完毕，但是不会等待守护线程，守护线程是为用户线程服务的
 * 默认：线程是用户线程
 * @author: CTH
 **/
public class TestDaemon {
    public static void main(String[] args) {
    new Thread(new You()).start();
    Thread t = new Thread(new God());
    t.setDaemon(true);//设为守护线程，用户线程结束，守护线程也被终止
    t.start();
    }
}
class You implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<365*100; i++) {
            System.out.println("我活了"+ i+"天");
        }
        System.out.println("朕的江山给你们了！");
    }
}
class God implements Runnable {
    @Override
    public void run() {
        for (;;) {
            System.out.println("佛祖保佑你");
        }
    }
}
