package Net.TCP.Talk1;

import java.io.*;
import java.net.Socket;

/**
 * @author: CTH
 **/
public class Channel implements Runnable {
    private Socket client;
    private DataOutputStream dos;
    private DataInputStream dis;
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
    private String receive() {
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
            send(msg);
        }
    }
}
