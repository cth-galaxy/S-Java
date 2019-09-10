package Thread.Syn;

/**
 * 模拟银行取钱
 * 无锁造成数据出错
 * @author: CTH
 **/
public class TestUnSafe {
    public static void main(String[] args) {
        Account account = new Account(100,"买房");
        Drawing you = new Drawing(account, 80);
        Drawing wife = new Drawing(account, 90);
        new Thread(you,"可悲的你").start();
        new Thread(wife,"happy的她").start();

    }
}
class Account {
    int accountMoney;
    String name;

    public Account(int accountMoney, String name) {
        this.accountMoney = accountMoney;
        this.name = name;
    }
}
class Drawing implements Runnable {
    Account account;
    int drawingMoney;//取钱数
    int pocketMoney;//口袋钱数

    public Drawing(Account account, int drawingMoney) {
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.accountMoney-drawingMoney < 0) {
            return;
        }
        account.accountMoney -= drawingMoney;
        pocketMoney += drawingMoney;
        System.out.println(Thread.currentThread().getName()+ "-->" +account.accountMoney);
        System.out.println(Thread.currentThread().getName()+ "-->" +pocketMoney);
    }
}