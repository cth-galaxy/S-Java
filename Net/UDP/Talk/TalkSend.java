package Net.UDP.Talk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端
 * @author: CTH
 **/
public class TalkSend implements Runnable {
    private DatagramSocket client;
    private BufferedReader reader;
    private String toIP;//接受端ip
    private int toPort;//接收端端口

    public TalkSend(int port, String toIP, int toPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        // 1、使用DatagramSocket 指定端口，创建发送端
        try {
            client = new DatagramSocket(port);//发送端端口
            // 2、准备数据，一定要将数据转换为字节数组
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                String msg = null;
                msg = reader.readLine();
                byte[] datas = msg.getBytes();
                // 3、封装成DatagramPacket包裹，需指定目的地
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                        new InetSocketAddress(toIP, toPort));
                // 4、发送包裹 send（DatagramPacket p）
                client.send(packet);
                if (msg.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 5、释放资源
        client.close();
    }
}
