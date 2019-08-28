package IO;

import java.io.*;
import java.net.URL;

/**
 * 转换流：InputStreamReader,InputStreamWriter
 * 1、字节流转字符流
 * 2、指定字符集
 * @author: CTH
 **/
public class IO5 {
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(//Buffered增加读取效率
                    new InputStreamReader(//将字节流转字符流，方便BufferedReader
                            new URL("https://www.baidu.com/").openStream(),"UTF-8"
                            //指定字符集
                    )
            );
            writer = new BufferedWriter(//利用buffered提升效率，writer处理文本
                        new OutputStreamWriter(//转字符流
                                new FileOutputStream("src/IO/baidu.html")//字节流
                        )
                    );
            String msg = null;
            while ((msg = reader.readLine()) != null) {
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer == null) {
                return;
            }else {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader == null) {
                return;
            }else {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
