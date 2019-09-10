package Net.TCP;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: CTH
 **/
public class LoginServer {
    public static void main(String[] args) throws IOException {
        System.out.println("--------Server--------");
        //1、创建服务端
        ServerSocket server = new ServerSocket(9999);
        //2、阻塞等待接收
        Socket client = server.accept();
        //3、操作
        //输入流接收数据
        DataInputStream dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
        String msg = dis.readUTF();
        String uname = null;
        String upwd = null;
        String[] datas = msg.split("&");
        for (String info: datas) {
            String[] userInfo = info.split("=");
            if (userInfo[0].equals("uname")) {
                uname = userInfo[1];
                System.out.println("用户名："+userInfo[1]);
            }else  if (userInfo[0].equals("upwd")) {
                upwd = userInfo[1];
                System.out.println("密码："+userInfo[1]);
            }
        }
        //给客户端返回结果，输出流
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        if (uname.equals("galaxy") && upwd.equals("1314520")) {
            dos.writeUTF("登录成功，欢迎回来");
        } else {
            dos.writeUTF("账号不存在或密码错误");
        }
         dos.flush();
        //释放资源
        dis.close();
        dos.close();
        client.close();
    }
}
