package IO;

import java.io.*;

/**
 * 字符流利用buffer。可以像字节流一样直接套用。
 * 在执行操作时可以选择它自有的方法去写readline、newline
 * @author: CTH
 **/
public class BIO2 {
    public static void main(String[] args) {
        File src = new File("src/IO/剑来.txt");
        File path = new File("src/IO/c_剑来.txt");
        copy(src, path);
    }

    public static void copy(File src, File enPath) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(src));
            bw = new BufferedWriter(new FileWriter(enPath));
            String line = null;
            while ((line = br.readLine()) != null) {//调用BufferedR、W的私有方法
                //readline按行读取数据，无数据返回空
                bw.write(line);
                bw.newLine();//写出换行
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br == null) {
                return;
            }else {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw == null) {
                return;
            }else {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
