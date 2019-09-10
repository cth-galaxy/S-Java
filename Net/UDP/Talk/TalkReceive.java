package Net.UDP.Talk;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**接收端
 * @author: CTH
 **/
public class TalkReceive implements Runnable {
    private DatagramSocket server;

    public TalkReceive(int port) {
        // 1、使用DatagramSocket 指定端口，创建接收端
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            // 2、准备容器，封装成DatagramPacket包裹
            byte[] buffer = new byte[1024*10];
            DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
            // 3、阻塞式接受包裹 receive（DatagramPacket p）
            try {
                server.receive(packet);
                // 4、分析数据
                byte[] datas = packet.getData();
                int len = packet.getLength();
                String msg= new String(datas,0, len);
                System.out.println(msg);
                if (msg.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 5、释放资源
        server.close();
    }
}
