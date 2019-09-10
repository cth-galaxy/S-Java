package Thread.Syn;

/**
 * 生产者、消费者模式：2、信号灯法
 * @author: CTH
 **/
public class PCModel02 {
    public static void main(String[] args) {
    TV tv = new TV();
    new Player(tv).start();
    new Audience(tv).start();
    }
}
//生产者--》演员
class Player extends Thread {
    TV tv;
    public Player(TV tv) {
        this.tv = tv;
    }
    @Override
    public void run() {
        for (int i=1; i<5; i++) {
            switch (i) {
                case 1: this.tv.play("奇葩说");
                break;
                case 2: this.tv.play("好污");
                    break;
                case 3: this.tv.play("拿立白洗洗");
                    break;
                case 4: this.tv.play("纯洁如一张白纸");
                    break;
                default:this.tv.play("江郎才尽！！");
            }
        }
    }
}
//消费者--》听众
class Audience extends Thread{
    TV tv;
    public Audience(TV tv) {
        this.tv = tv;
    }
    @Override
    public void run() {
        for (;;) {
            tv.watch();
        }
    }
}
//同一资源--》TV
class TV{
    String voice;
    //信号灯
    //T--演员表演
    //F--听众收听
    boolean flag = true;
    public synchronized void play(String voice){
        if (!false) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了-->"+voice);
        this.voice = voice;
        this.notifyAll();
        this.flag = !this.flag;
    }
    public synchronized void  watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了-->"+voice);
        this.notifyAll();
        this.flag = !this.flag;
    }
}

