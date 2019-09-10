package Thread.Syn;

/**
 * 同步方法
 * 要锁对目标，锁的是对象资源
 * @author: CTH
 **/
public class Web12306 {
    public static void main(String[] args) {
        TrainTicket trainTicket = new TrainTicket(100);
        Thread t1 = new Thread(trainTicket,"黄牛");
        Thread t2 = new Thread(trainTicket,"倒手");
        Thread t3 = new Thread(trainTicket,"票贩子");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(5);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
class TrainTicket implements Runnable {
    private  int tickets;
    private  boolean flag = true;//是否有票

    public TrainTicket(int tickets) {
        this.tickets = tickets;
    }

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(1000);//模拟网络延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getTicket();
        }
    }
    public synchronized void getTicket() {//锁定修改数据的方法，防止线程同时操作造成数据出错
        if (tickets <=0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "-->" + (tickets--));
    }
}
