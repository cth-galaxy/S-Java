package IO;

import java.io.*;

/**
 * 标准步骤
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author: CTH
 **/
public class IO2 {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            //创建源
            //选择流
            is = new FileInputStream("F:/JavaCode/src/c.txt");
            //操作
            int temp = 0;
            while ((temp = is.read()) != -1) {
                System.out.print((char)temp);
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
