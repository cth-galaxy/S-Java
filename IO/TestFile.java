package IO;

import java.io.File;
import java.io.IOException;

/**
 * @author: CTH
 **/
public class TestFile {
    public static void main(String[] args) throws IOException {
        String path = "src/a.txt";
        File src = new File(path);
        //常用方法
        //function(src);
        //创建新文件
        String pathname = "src/b.txt";
        File file = new File(pathname);
        boolean flag =file.createNewFile();
        System.out.println(flag);
        flag = file.delete();
        System.out.println(flag);
    }

    public static void function(File file) {
            System.out.println(file.length());
            System.out.println(file.getName());
            System.out.println(file.getPath());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.exists());
            System.out.println(file.isFile());
    }
}

