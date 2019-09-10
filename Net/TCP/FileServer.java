package Net.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**上传文件
 * 1、指定端口，使用ServerSocket创建服务器
 * 2、阻塞式等待连接  accept
 * 3、操作：输入输出流操作
 * 4、释放资源
 * @author: CTH
 **/
public class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-------Server-------");
        //1、指定端口，使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(9999);
        //2、阻塞式等待连接  accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        //3、操作：输入输出流操作
        //从客户端读入
        InputStream is = new BufferedInputStream(client.getInputStream());
        //从程序写出
        OutputStream os = new BufferedOutputStream(new FileOutputStream("a_tcp.txt"));
        //操作
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=is.read(flush)) != -1) {
            os.write(flush,0 , len);
        }
        os.flush();
        //4、释放资源
        is.close();
        os.close();
        client.close();
    }
}
