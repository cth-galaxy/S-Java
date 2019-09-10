package Net.TCP.Talk2;

import java.io.*;
import java.net.Socket;

import static Net.TCP.Talk2.Chat.all;

/**
 * @author: CTH
 **/
public class Channel implements Runnable {
    private Socket client;
    private DataOutputStream dos;
    private DataInputStream dis;
    private String name;
    private boolean isRuning = true;

    public Channel(Socket client) {
        this.client = client;
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(client.getOutputStream())
            );
            dis = new DataInputStream(
                    new BufferedInputStream(client.getInputStream())
            );
            this.name = receive();
            this.send("欢迎你加入玩乐群");
            sendOther(this.name+ "加入了群聊",true);
        } catch (IOException e) {
            e.printStackTrace();
            isRuning = false;
            new Close().release(dos, dis, client);
        }
    }

    private void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            isRuning = false;
            new Close().release(dos, client);
        }
    }
    private void sendOther(String msg, boolean isSys) {
        for (Channel other:all) {
            if (other == this) {//自己不发
                continue;
            }else {
                if (isSys) {
                    other.send("系统："+msg);
                }else {
                    other.send(this.name + ":\n" + msg);
                }
            }
        }
    }
    public String receive() {
        try {
            String msg = dis.readUTF();
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
            isRuning = false;
            new Close().release(dis);
            return null;
        }
    }
    @Override
    public void run() {
        while (isRuning) {
            String msg = receive();
            sendOther(msg, false);
        }
    }
}
