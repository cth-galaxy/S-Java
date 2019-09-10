package Net.UDP;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**发送端-->对象
 * 1、使用DatagramSocket 指定端口，创建接收端
 * 2、准备容器，封装成DatagramPacket包裹
 * 3、阻塞式接受包裹 receive（DatagramPacket p）
 * 4、分析数据
 * 5、释放资源
 * @author: CTH
 **/
public class ServerObjUdp {
    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动。。。。。");
        // 1、使用DatagramSocket 指定端口，创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        // 2、准备容器，封装成DatagramPacket包裹
        byte[] buffer = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        // 3、阻塞式接受包裹 receive（DatagramPacket p）
        server.receive(packet);
        // 4、分析数据,将字节数据转为对象类型(反序列化)-->写入
        byte[]datas = packet.getData();
        ByteArrayInputStream bais = new ByteArrayInputStream(datas);
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(bais));
        Person p = (Person)ois.readObject();
        System.out.println(p.toString());

        // 5、释放资源
        bais.close();
        ois.close();
        server.close();
    }
}
