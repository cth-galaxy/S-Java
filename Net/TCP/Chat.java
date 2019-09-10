package Net.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单人收发消息
 * @author: CTH
 **/
public class Chat {
    public static void main(String[] args) {
        try {
            //创建服务端
            ServerSocket server = new ServerSocket(9999);
            //阻塞等待接收
            Socket client = server.accept();

            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(client.getInputStream())
            );
            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(client.getOutputStream())
            );
            boolean isRuning = true;
            while (isRuning) {
                //接收消息
                String msg = dis.readUTF();
                //发送消息
                dos.writeUTF(msg);
                dos.flush();
            }
            //释放资源
            if (dis != null) {
                dis.close();
            }
            if (dos != null) {
                dos.close();
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
