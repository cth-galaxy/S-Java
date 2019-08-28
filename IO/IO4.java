package IO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 输出流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 * @author: CTH
 **/
public class IO4 {
    public static void main(String[] args) {
        OutputStream os = null;
        try {
            //创源选流
            os = new FileOutputStream("src/d.txt");
            //操作（写出）
            String msg = "There are trees and branches in the mountains, " +
                    "but you don't know the pleasure in your heart.";
            byte[] datas = msg.getBytes();//写出字符串。转字节数组
            os.write(datas,0, datas.length);
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null == os) {
                return;
            } else {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
