package Thread.Syn;

/**
 * 同步块
 * 要锁对目标，锁的是对象资源
 * @author: CTH
 **/
public class ATM {
    public static void main(String[] args) {
        Bank account = new Bank(100,"买房");
        new Thread(new DrawMoney(account, 80), "可悲的你").start();
        new Thread(new DrawMoney(account, 90), "happy的她").start();
    }
}

class Bank {
    private int money;
    private String name;

    public Bank(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
class DrawMoney implements Runnable {
    Bank account;
    private int drawingMoney;//取钱数
    private int pocketMoney;//口袋钱数

    public DrawMoney(Bank account, int drawingMoney) {
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getMoney();
    }

    public void getMoney() {
        synchronized (account) {//同步块锁定账户
            if (account.getMoney() - drawingMoney <= 0) {
                return;
            }
            account.setMoney(account.getMoney() - drawingMoney);
            pocketMoney += drawingMoney;
            System.out.println(account.getName() + "余额-->" + account.getMoney());
            System.out.println(Thread.currentThread().getName() + "口袋金额-->" + pocketMoney);
        }
    }
}