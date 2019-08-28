package IO;

import java.io.File;

/**
 * @author: CTH
 **/
public class TestFileDir {
    public static void main(String[] args) {
        File dir = new File("F:/JavaCode/src/dir/test");
        //mkdir父级目录不存在，成功无法创建目录
        boolean flag = dir.mkdir();
        System.out.println(flag);
        //mkdirs若父级目录不存在则一起创建
        flag = dir.mkdirs();
        System.out.println(flag);
        System.out.println("################");
        //list 列出下一级目录
        File dir1 = new File("F:/JavaCode/src");
        String[] subNames = dir1.list();
        for (String s:subNames) {
            System.out.println(s);
        }
        System.out.println("################");
        //listFile 列出下一级父类对象
        File[] subFiles = dir1.listFiles();
        for (File s:subFiles) {
            System.out.println(s.getAbsolutePath());
        }
    }
}
