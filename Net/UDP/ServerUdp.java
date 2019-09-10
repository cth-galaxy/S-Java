package Net.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**发送端
 * 1、使用DatagramSocket 指定端口，创建接收端
 * 2、准备容器，封装成DatagramPacket包裹
 * 3、阻塞式接受包裹 receive（DatagramPacket p）
 * 4、分析数据
 * 5、释放资源
 * @author: CTH
 **/
public class ServerUdp {
    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动。。。。。");
        // 1、使用DatagramSocket 指定端口，创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        // 2、准备容器，封装成DatagramPacket包裹
        byte[] buffer = new byte[1024*10];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        // 3、阻塞式接受包裹 receive（DatagramPacket p）
        server.receive(packet);
        // 4、分析数据
        byte[]datas = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas,0 ,len));
        // 5、释放资源
        server.close();
    }
}
