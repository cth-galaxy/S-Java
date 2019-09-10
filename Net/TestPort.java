package Net;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * InetSocketAddress   IP+Port
 * @author: CTH
 **/
public class TestPort {
    public static void main(String[] args) {
        InetSocketAddress s = new InetSocketAddress("localhost", 21);
        System.out.println(s.getAddress());
        System.out.println(s.getHostName());
        System.out.println(s.getPort());

        InetAddress addr = s.getAddress();
        System.out.println(addr.getHostName());
    }
}
