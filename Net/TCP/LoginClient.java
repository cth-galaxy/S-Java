package Net.TCP;

import java.io.*;
import java.net.Socket;

/**
 * @author: CTH
 **/
public class LoginClient {
    public static void main(String[] args) throws IOException {
        System.out.println("--------Client--------");
        //1、连接服务端
        Socket client = new Socket("localhost", 9999);
        //2、操作
        //用户输入
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名:");
        String uname = reader.readLine();
        System.out.println("请输入密码:");
        String upwd = reader.readLine();
        //输出流发送
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
        dos.flush();
        //接收服务端反馈
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
        //释放资源
        dos.close();
        dis.close();
        client.close();
    }
}
