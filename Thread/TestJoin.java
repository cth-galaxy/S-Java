package Thread;

/**
 * jion合并线程，插队线程。使其他线程阻塞
 * @author: CTH
 **/
public class TestJoin {
    public static void main(String[] args) {
        System.out.println("爸爸和儿子买烟的故事");
        new Thread(new Father()).start();
    }
}
class Father implements Runnable {
    @Override
    public void run() {
        System.out.println("老爸想抽烟，发现烟没了");
        System.out.println("叫儿子去买中华");
        Thread t = new Thread(new Son());
        t.start();
        try {
            t.join();//老爸必须等儿子买烟回来，所以儿子进行插队
        } catch (InterruptedException e) {
            System.out.println("儿子走丢了，老爸去找儿子");
        }
        System.out.println("老爸接过烟，把零钱给了儿子");
        System.out.println("儿子接过零钱回游戏厅了。。。");
    }
}
class Son implements Runnable {
    @Override
    public void run() {
        System.out.println("接过老爸的钱去买烟");
        System.out.println("路边发现游戏厅，进去玩了10秒");
        for (int i=1; i<11; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("儿子玩嗨了，忘了买烟");
            }
            System.out.println(i + "秒过去了。。。");
        }
        System.out.println("赶紧去买烟");
        System.out.println("拿着中华回家了");
    }
}
