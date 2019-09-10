package Net.TCP;

import java.io.*;
import java.net.Socket;

/**
 * @author: CTH
 **/
public class Client1 {
    public static void main(String[] args) {

        try {
            //创建客户端，连接服务器
            Socket client1 = new Socket("localhost", 9999);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            DataOutputStream dos = new DataOutputStream(
                    new BufferedOutputStream(client1.getOutputStream())
            );
            DataInputStream dis = new DataInputStream(
                    new BufferedInputStream(client1.getInputStream())
            );
            boolean isRuning = true;
            while (isRuning) {
                //发送消息
                dos.writeUTF(br.readLine());
                dos.flush();
                //接收消息
                System.out.println(dis.readUTF());
            }

            //释放资源
            //释放资源
            if (dos != null) {
                dos.close();
            }
            if (dis != null) {
                dis.close();
            }
            client1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
