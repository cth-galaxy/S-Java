package IO;

import java.io.*;

/**
 * 理解io
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author: CTH
 **/
public class IO1 {
    public static void main(String[] args) {
        //创建源
        File src = new File("F:/JavaCode/src/b.txt");
        //选择流
        try {
            InputStream is = new FileInputStream(src);
            //操作（读）
            int data1 = is.read();//第一个数据（字节）L
            int data2 = is.read();//o
            int data3 = is.read();//v
            int data4 = is.read();//e
            int data5 = is.read();//-1；若无数据，则返回-1；
            System.out.println((char) data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println((char)data4);
            System.out.println(data5);
            //释放资源
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
