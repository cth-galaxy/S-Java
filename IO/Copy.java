package IO;

import java.io.*;

/**字节输入输出流
 * 将文件转字节，然后又字节输出文件
 * 文件--》程序--》字节--》程序--》文件
 * @author: CTH
 **/
public class Copy {
    public static void main(String[] args) {
        File src = new File("src/IO/ice.jpg");
        File path = new File("src/IO/c_ice.jpg");
        copyFBBF(src, path);
    }

    public static void copyFBBF(File src, File enPath) {
        //文件输入流
        InputStream is = null;
        //字节输入流。也可以是 InputStream bais
        ByteArrayInputStream bais = null;
        //字节输出流
        ByteArrayOutputStream baos = null;
        //文件输出流
        OutputStream os = null;
        try {
            //操作
            is = new FileInputStream(src);
            baos = new ByteArrayOutputStream();

            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {//读文件
                baos.write(flush, 0, len);//写出字节
            }

            bais = new ByteArrayInputStream(baos.toByteArray());//读字节
            os = new FileOutputStream(enPath);
            while ((len = bais.read(flush)) != -1) {
                os.write(flush, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源。ByteArrayIputStream、ByteArrayOutputStream
            //（字节流不需要通知系统释放资源，它访问的是内存，不是硬盘文件）
            if (os == null) {
                return;
            }else {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os == null) {
                return;
            }else {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
