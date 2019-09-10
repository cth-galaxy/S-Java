package Net.TCP;

import java.io.*;
import java.net.Socket;

/**上传文件
 * 1、建立连接：使用Socket创建客户端-->指定服务端的ip+port
 * 2、操作：输入输出流操作
 * 3、释放资源
 * @author: CTH
 **/
public class FileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("--------Client--------");
        //1、建立连接：使用Socket创建客户端-->指定服务端的ip+port
        Socket client = new Socket("localhost", 9999);
        //2、操作：输入输出流操作
        //读入文件
        InputStream is = new BufferedInputStream(new FileInputStream("src/a.txt"));
        //写出到客户端
        OutputStream os = new BufferedOutputStream(client.getOutputStream());
        //操作：流对接
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=is.read(flush)) != -1) {
            os.write(flush,0, len);
        }
        os.flush();
        //3、释放资源
        is.close();
        os.close();
        client.close();
    }
}
