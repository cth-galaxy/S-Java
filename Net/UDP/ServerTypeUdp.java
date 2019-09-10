package Net.UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**发送端-->基本数据类型
 * 1、使用DatagramSocket 指定端口，创建接收端
 * 2、准备容器，封装成DatagramPacket包裹
 * 3、阻塞式接受包裹 receive（DatagramPacket p）
 * 4、分析数据
 * 5、释放资源
 * @author: CTH
 **/
public class ServerTypeUdp {
    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动。。。。。");
        // 1、使用DatagramSocket 指定端口，创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        // 2、准备容器，封装成DatagramPacket包裹
        byte[] buffer = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        // 3、阻塞式接受包裹 receive（DatagramPacket p）
        server.receive(packet);
        // 4、分析数据,将字节数据转为基本类型-->写入
        byte[]datas = packet.getData();

        ByteArrayInputStream bias = new ByteArrayInputStream(datas);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(bias));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean b = dis.readBoolean();
        System.out.println(msg +"--->"+ b +"-->"+ age);
        // 5、释放资源
        bias.close();
        dis.close();
        server.close();
    }
}
