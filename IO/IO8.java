package IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 随机访问文件：RandomAccessFile
 * 利用该类实现文件分割下载
 * @author: CTH
 **/
public class IO8 {
    public static void main(String[] args) throws IOException {
        File src = new File("src/IO/fly.txt");
        //文件大小
        long fileLen = src.length();
        //分块大小
        int blockSize = 512;
        //分块数量
        int n = (int)Math.ceil(fileLen*1.0/blockSize);//向上取整
        //起始位置
        int beginPos = 0;
        //实际大小
        int actualSize = blockSize>fileLen?(int)fileLen:blockSize;//若大于内容长度，实际为内容长度
        for (int i=0; i<n; i++) {
            beginPos = i*blockSize;
            if (i == n-1) {
                actualSize = (int)fileLen;
            }else {
                actualSize = blockSize;
                fileLen -= actualSize;
            }
            splitFile(src,beginPos,actualSize);
            System.out.println("*******************************************");
        }
    }

    public static void splitFile(File src, int beginPos, int actualSize) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(src,"r");
        raf.seek(beginPos);
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len = raf.read(flush)) != -1) {
            if (len > actualSize) {
                System.out.println(new String(flush,0,actualSize));
            }else {
                System.out.println(new String(flush,0,len));
                break;
            }
        }
    }


}
