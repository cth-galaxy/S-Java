package IO;

import java.io.*;

/**
 * 利用上输入流、输出流copy
 * @author: CTH
 **/
public class TestCopy {
    public static void main(String[] args) {
        File src = new File("images/lol.jpg");
        File path = new File("src/c_lol.jpg");
        copyFile(src, path);

    }

    public static void copyFile(File src, File endPath) {
        //选择流
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            //FileOutputStream构造方法append参数：默认false。当为true时可以在后面继续添加
            os = new FileOutputStream(endPath);
            //操作
            byte[] flush = new byte[1024];//缓冲1K
            int len = -1;
            while ((len = is.read(flush)) != -1) {//读
                os.write(flush,0, len);//写
                //写入时字节的长度应为返回值len，若是flush.length则长度固定
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放--》先开后释放
            if (os == null) {
                return;
            }else {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is == null) {
                return;
            }else {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
