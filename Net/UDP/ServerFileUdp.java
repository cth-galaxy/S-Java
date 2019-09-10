package Net.UDP;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**发送端  文件
 * 1、使用DatagramSocket 指定端口，创建接收端
 * 2、准备容器，封装成DatagramPacket包裹
 * 3、阻塞式接受包裹 receive（DatagramPacket p）
 * 4、分析数据
 * 5、释放资源
 * @author: CTH
 **/
public class ServerFileUdp {
    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动。。。。。");
        // 1、使用DatagramSocket 指定端口，创建接收端
        DatagramSocket server = new DatagramSocket(9999);
        // 2、准备容器，封装成DatagramPacket包裹
        byte[] buffer = new byte[1024*10];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        // 3、阻塞式接受包裹 receive（DatagramPacket p）
        server.receive(packet);
        // 4、分析数据 将字节数组转为文件
        byte[]datas = packet.getData();
        int length = packet.getLength();
        ByteArrayInputStream bais = new ByteArrayInputStream(datas, 0, length);
        FileOutputStream fos = new FileOutputStream(new File("src/c_a.txt"));
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=bais.read(flush)) != -1) {
            fos.write(flush,0, len);
        }
        fos.flush();
        // 5、释放资源
        fos.close();
        bais.close();
        server.close();
    }
}
