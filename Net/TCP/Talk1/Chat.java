package Net.TCP.Talk1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 对象封装
 * @author: CTH
 **/
public class Chat {
    public static void main(String[] args) {
        System.out.println("-------Server-------");
        //创建服务端
        ServerSocket server = null;
        Socket client = null;
        boolean isRuning = true;
        try {
            server = new ServerSocket(9999);
            while (isRuning) {
                //阻塞等待
                client = server.accept();
                new Thread(new Channel(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            isRuning = false;
            new Close().release(server, client);
        }
    }
}
