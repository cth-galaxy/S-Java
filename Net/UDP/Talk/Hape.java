package Net.UDP.Talk;

/**
 * @author: CTH
 **/
public class Hape {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost",7777)).start();//发送
        new Thread(new TalkReceive(6666)).start();//接收
    }
}
