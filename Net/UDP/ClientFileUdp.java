package Net.UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**客户端  发送文件
 * 1、使用DatagramSocket 指定端口，创建发送端
 * 2、准备数据，一定要将数据转换为字节数组
 * 3、封装成DatagramPacket包裹，需指定目的地
 * 4、发送包裹 send（DatagramPacket p）
 * 5、释放资源
 * @author: CTH
**/
public class ClientFileUdp {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动。。。。。");
        // 1、使用DatagramSocket 指定端口，创建发送端
        DatagramSocket client = new DatagramSocket(9998);//发送端端口
        // 2、准备数据，一定要将数据转换为字节数组
        //将文件转字节数组-->对接流
        //1、读文件到程序；2、将文件转为字节数组
        File file = new File("src/a.txt");
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = fis.read(flush)) != -1) {
            baos.write(flush,0, len);
        }
        baos.flush();
        byte[] datas = baos.toByteArray();
        // 3、封装成DatagramPacket包裹，需指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost",9999));
        // 4、发送包裹 send（DatagramPacket p）
        client.send(packet);
        // 5、释放资源
        baos.close();
        fis.close();
        client.close();
    }
}
