package Thread;

/**
 * 多线程模拟龟兔赛跑
 * @author: CTH
 **/
public class Racer implements Runnable {
    private String winner;

    @Override
    public void run() {
        for (int steps = 1; steps<=100; steps++) {
            boolean flag = gameOver(steps);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() +"--->"+ steps);

        }
    }
    public boolean gameOver(int steps) {
        if (winner != null) {
            return true;
        }else {
            if (steps == 100) {
                System.out.println("winner-->" + Thread.currentThread().getName());
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer, "tortoise").start();
        new Thread(racer, "rabbit").start();
    }
}
