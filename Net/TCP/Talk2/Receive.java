package Net.TCP.Talk2;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;


/**
 * @author: CTH
 **/
public class Receive implements Runnable {
    private Socket client;
    private DataInputStream dis;
    private boolean isRuning = true;

    public Receive(Socket client) {
        this.client = client;
        try {
            dis = new DataInputStream(
                    new BufferedInputStream(client.getInputStream())
            );
        } catch (IOException e) {
            e.printStackTrace();
            isRuning = false;
            new Close().release(dis,client);
        }
    }
    public String receive() {
        try {
            String msg = dis.readUTF();
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
            isRuning = false;
            new Close().release(dis,client);
            return null;
        }
    }

    @Override
    public void run() {
        while (isRuning) {
            String msg = receive();
            System.out.println(msg);
        }
    }
}
