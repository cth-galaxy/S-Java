package Thread;

/**
 * yield礼让线程，直接进入就绪状态，等待cpu重新调度
 * @author: CTH
 **/
public class TestYeild {
    public static void main(String[] args) {
        //lambda方式简写run方法
        new Thread(() -> {
            for (int i=0; i<100; i++) {
                System.out.println("lambda-->" + i);
            }
        }).start();

        for (int i=0; i<100; i++) {
            if (i%20 == 0) {
                Thread.yield();
            }
            System.out.println("main-->"+ i);
        }
    }
}
