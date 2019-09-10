package Net;


import java.net.URL;

/**
 * @author: CTH
 **/
public class TestURL {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.baidu.com:80/index.html/?wd=xbox#a");
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getPort());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());
    }
}
