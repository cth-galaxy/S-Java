package IO;

import java.io.*;

/**
 * 封装 流 代码
 * 自己理解：利用继承父类即多态来封装相同的代码段
 * @author: CTH
 **/
public class FileUtils {
    public static void main(String[] args) {
        //文件-->文件
        try {
            InputStream is = new FileInputStream("src/IO/lol.jpg");
            OutputStream os = new FileOutputStream("src/IO/c_lol.jpg");
            copy(is,os);
            close(os,is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件-->字节
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("src/IO/lol.jpg");
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is,os);//应该有自动类型转换
            datas = os.toByteArray();
            close(os,is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //字节-->文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("src/IO/cc_lol.jpg");
            copy(is, os);
            close(os,is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 对接流
     * @param is
     * @param os
     */

    public static void copy(InputStream is, OutputStream os) {
        try {
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
            os.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 另一种方式：try...with...resource。由系统自己释放
     * try(is;os){
     *   //操作
     * }
     * 注：该方式在版本7中支持，8不支持
     */
    /**
     * 释放资源的一种方式
     * @param ios
     */
    public static void close(Closeable... ios) {//Closeable... ios Java可变参数
        for (Closeable io:ios) {
            if (io == null) {
                return;
            }else {
                try {
                    io.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
