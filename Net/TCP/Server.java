package Net.TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 1、指定端口，使用ServerSocket创建服务器
 * 2、阻塞式等待连接  accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 * @author: CTH
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("-------Server-------");
        //1、指定端口，使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(9999);
        //2、阻塞式等待连接  accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        //3、操作：输入输出流操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
        //4、释放资源
        dis.close();
        client.close();
    }
}
