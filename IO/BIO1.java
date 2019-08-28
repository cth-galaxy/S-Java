package IO;

import java.io.*;

/**
 * Buffer 字节流
 * 用法：只需要将字节流用包起来即可，当达到默认的8k时自动发送，可以修改大小
 * @author: CTH
 **/
public class BIO1 {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        File src = new File("src/IO/nazha.flv");
        File path = new File("src/IO/c_nazha.flv");
        copy(src, path);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
    }

    /**
     * 复制
     * @param src
     * @param enPath
     */

    public static void copy (File src, File enPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(enPath));
            byte[] flush = new byte[1024*2];
            int len = -1;
            while ((len = bis.read(flush)) != -1) {
                bos.write(flush, 0, len);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bos == null) {
                return;
            }else {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis == null) {
                return;
            }else {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
