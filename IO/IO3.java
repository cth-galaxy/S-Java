package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * * 标准步骤(分段读取)
 *  * 1、创建源
 *  * 2、选择流
 *  * 3、操作
 *  * 4、释放资源
 * @author: CTH
 **/
public class IO3 {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            //创建源
            //选择流
            is = new FileInputStream("F:/JavaCode/src/c.txt");
            //操作
            byte[] flush = new byte[10];//缓冲容器，相当于一段大小
            int len = -1;//缓冲容器实际读取了多长;若无内容返回-1
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush,0,len);//字节数组转字符串
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if (null == is) {
                return;
            } else {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
