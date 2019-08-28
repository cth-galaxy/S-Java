package IO;

import java.io.*;

/**
 * 利用字符流复制字符文件
 * @author: CTH
 **/
public class CopyTxT {
    public static void main(String[] args) {
        File src = new File("src/IO/e.txt");
        File path = new File("src/IO/c_e.txt");
        copyTxt(src, path);
    }

    public static void copyTxt(File src, File enPath) {
        Reader reader = null;
        Writer writer = null;
        try {
            reader = new FileReader(src);
            writer = new FileWriter(enPath);
            //操作
            char[] flush = new char[20];
            int len = -1;
            while ((len = reader.read(flush)) != -1) {
                writer.write(flush, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            if (writer == null) {
                return;
            }else {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
