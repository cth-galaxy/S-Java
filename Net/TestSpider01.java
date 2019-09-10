package Net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 爬虫
 * 网站不给权限，可以模拟浏览器请求下载资源
 * @author: CTH
 **/
public class TestSpider01 {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url = new URL("https://www.dianping.com");
        //下载资源
        //模拟浏览器
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18362");
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(
                                new File("src/dianping.html"))));
        String msg = null;
        while ((msg=br.readLine()) != null) {
            bw.write(msg);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
