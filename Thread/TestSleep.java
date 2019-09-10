package Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep 实现倒计时
 * @author: CTH
 **/
public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        Date endTime = new Date(System.currentTimeMillis() + 1000 * 10);
        long end = endTime.getTime();
        boolean flag = true;
        while (flag) {
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime() - 1000);
            if (end - 10000 > endTime.getTime()){
                flag = false;
            }
        }
    }
}
