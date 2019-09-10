package Net.TCP.Talk2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 群聊
 * @author: CTH
 **/
public class Client2 {
    public static void main(String[] args) {
        System.out.println("-------Client2--------");
        //创建发送端，连接服务器
        try {
                Socket client2 = new Socket("localhost", 9999);
                System.out.println("系统:请输入用户名");
                BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in)
                );
                String name = br.readLine();
                //发送
                new Thread(new Send(client2, name)).start();
                //接收
                new Thread(new Receive(client2)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
