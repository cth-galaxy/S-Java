package Net;

import java.io.*;
import java.net.URL;

/**
 * 爬虫
 * @author: CTH
 **/
public class TestSpider {
    public static void main(String[] args) throws Exception {
        //获取URL
        URL url = new URL("https://www.jd.com");
        //下载资源
        InputStream is = url.openStream();//打开输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(
                                new File("src/jd.html"))));
        String msg = null;
        while ((msg=br.readLine()) != null) {
            bw.write(msg);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
