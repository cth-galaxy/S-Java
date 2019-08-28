package IO;

import java.io.File;

/**
 * 递归打印整个子孙级目录
 * @author: CTH
 **/
public class TestDir {
    public static void main(String[] args) {
        String path = "F:/JavaCode/src";
        File src = new File(path);
        printDir(src,0);
    }

    public static void printDir (File file, int deep) {
        for (int i=0; i<deep; i++) {
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file == null || !file.exists()) {
            return;
        } else if (file.isDirectory()) {
            for (File s:file.listFiles()) {
                printDir(s,deep+1);
            }
        }
    }
}
