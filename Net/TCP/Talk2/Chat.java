package Net.TCP.Talk2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 群聊
 * @author: CTH
 **/
public class Chat {
    static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();
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
                System.out.println("一个客户端连接");
                Channel c = new Channel(client);
                all.add(c);
                new Thread(c).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            new Close().release(server);
        }
    }
}
