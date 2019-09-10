package Net.TCP;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**多个客户端建立连接（多线程）
 * @author: CTH
 **/
public class MLoginServer {
    public static void main(String[] args) throws IOException {
        System.out.println("--------Server--------");
        boolean isRuning = true;
        //1、创建服务端
        ServerSocket server = new ServerSocket(9999);
        //2、阻塞等待接收
        while (isRuning) {
            Socket client = server.accept();
            new Thread(new Channel(client)).start();
        }
        server.close();
    }
}

class Channel implements Runnable {
    private Socket client;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String uname;
    private String upwd;

    public Channel(Socket client) {
        this.client = client;
    }

    //3、操作
    //输入流接收数据
    public void receive() {
        try {
            dis = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            String msg = dis.readUTF();
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
        } catch (IOException e) {
            e.printStackTrace();
            close();
        }

    }
    //给客户端返回结果，输出流
    public void send() {
        try {
            dos = new DataOutputStream(client.getOutputStream());
            if (uname.equals("galaxy") && upwd.equals("1314520")) {
                dos.writeUTF("登录成功，欢迎回来");
            } else {
                dos.writeUTF("账号不存在或密码错误");
            }
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void close() {
        //释放资源
        if (dis != null) {
            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dos != null) {
            try {
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        receive();
        send();
    }
}

