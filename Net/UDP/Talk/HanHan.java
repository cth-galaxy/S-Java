package Net.UDP.Talk;

/**
 * @author: CTH
 **/
public class HanHan {
    public static void main(String[] args) {
        new Thread(new TalkSend(8888,"localhost",6666)).start();//发送
        new Thread(new TalkReceive(7777)).start();//接收
    }
}
