package Net.UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**客户端-->基本数据类型
 * 1、使用DatagramSocket 指定端口，创建发送端
 * 2、准备数据，一定要将数据转换为字节数组
 * 3、封装成DatagramPacket包裹，需指定目的地
 * 4、发送包裹 send（DatagramPacket p）
 * 5、释放资源
 * @author: CTH
**/
public class ClientTypeUdp {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动。。。。。");
        // 1、使用DatagramSocket 指定端口，创建发送端
        DatagramSocket client = new DatagramSocket(9998);//发送端端口
        // 2、准备数据，一定要将数据转换为字节数组
        //基本数据类型转字节数组，利用数据流--->写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("我好混啊！");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.flush();
        byte[] datas = baos.toByteArray();
        // 3、封装成DatagramPacket包裹，需指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost",9999));
        // 4、发送包裹 send（DatagramPacket p）
        client.send(packet);
        // 5、释放资源
        baos.close();
        dos.close();
        client.close();
    }
}
