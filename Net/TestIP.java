package Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress类
 * 1、getLocalHost() 本机
 * 2、getByName  指定域名||IP
 * 方法：
 * getHostAddress() ip
 * getHostName() 名称。若无权限，返回IP
 * @author: CTH
 **/
public class TestIP {
    public static void main(String[] args) throws UnknownHostException {
        //本机IP
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
        //域名
        addr = InetAddress.getByName("www.baidu.com");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
        //IP
        addr = InetAddress.getByName("14.215.177.38");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
    }
}
