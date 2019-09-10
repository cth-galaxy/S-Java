package Net.TCP.Talk2;

import java.io.*;
import java.net.Socket;

/**
 * @author: CTH
 **/
public class Send implements Runnable {
    private Socket client;
    private DataOutputStream dos;
    private BufferedReader br;
    private String name;
    private boolean isRuning = true;

    public Send(Socket client, String name) {
        this.name = name;
        this.client = client;
        try {
            br = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            dos = new DataOutputStream(
                    new BufferedOutputStream(client.getOutputStream())
            );
            send(name);//发送名字
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            isRuning = false;
            new Close().release(dos,client);
        }
    }
    private String getMsg() {
        try {
            String msg = br.readLine();
            return msg;
        } catch (IOException e) {
            e.printStackTrace();
            isRuning = false;
            new Close().release(dos,client);
            return null;
        }
    }

    @Override
    public void run() {
        while (isRuning) {
            String msg = getMsg();
            send(msg);
        }
    }
}
