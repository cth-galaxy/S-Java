package Net.TCP.Talk1;

import java.io.IOException;
import java.net.Socket;

/**
 * @author: CTH
 **/
public class Client2 {
    public static void main(String[] args) {
        System.out.println("-------Client2--------");
        //创建发送端，连接服务器
        try {
            Socket client1 = new Socket("localhost", 9999);
                //发送
                new Thread(new Send(client1)).start();
                //接收
                new Thread(new Receive(client1)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
