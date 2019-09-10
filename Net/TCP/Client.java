package Net.TCP;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 1、建立连接：使用Socket创建客户端-->指定服务端的ip+port
 * 2、操作：输入输出流操作
 * 3、释放资源
 * @author: CTH
 **/
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("--------Client--------");
        //1、建立连接：使用Socket创建客户端-->指定服务端的ip+port
        Socket client = new Socket("localhost", 9999);
        //2、操作：输入输出流操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("你好！");
        dos.flush();
        //3、释放资源
        dos.close();
        client.close();
    }
}
