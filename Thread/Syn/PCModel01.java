package Thread.Syn;

/**
 * 生产者、消费者模式：1、管程法
 * @author: CTH
 **/
public class PCModel01 {
    public static void main(String[] args) {
        Container c = new Container();
        new Thread(new Producer01(c)).start();
        new Thread(new Consumer01(c)).start();
    }
}
class Producer01 implements Runnable{
    Container container;

    public Producer01(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            System.out.println("生产第"+i+"个的馒头");
            container.push(new Streambun(i));
        }
    }
}
class Consumer01 implements Runnable{
    Container container;

    public Consumer01(Container container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i=0; i<50; i++) {
            System.out.println("消费第"+container.pop().id +"个馒头");
        }
    }
}
//容器
class Container{
    Streambun[] buns = new Streambun[10];
    int count = 0;
    //生产
    public synchronized void push(Streambun bun) {
        if (count == buns.length) {//容器满，不能生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buns[count] = bun;
        count++;
        this.notifyAll();//已生产，可消费
    }
    //消费
    public synchronized Streambun pop() {
        if (count == 0) {//容器无数据，不能消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Streambun bun = buns[count];
        this.notifyAll();//已消费，可生产
        return bun;
    }

}
//数据
class Streambun{
    int id;

    public Streambun(int id) {
        this.id = id;
    }
}