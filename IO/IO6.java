package IO;

import java.io.*;

/**
 * 数据流
 * 数据流将“基本数据类型与字符串类型”作为数据源，从而允许程序以与机器无关的方式从底层输入输出流中操作Java基本数据类型与字符串类型。
 * DataInputStream和DataOutputStream提供了可以存取与机器无关的所有Java基础类型数据(如：int、double、String等)的方法。
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * @author: CTH
 **/
public class IO6 {
    public static void main(String[] args) throws IOException {
        //写出
        //要使用它的专有方法toByteArray，所以将它单独写出
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);//构造方法的参数为字节流
        dos.writeUTF("我好难啊");
        dos.writeInt(18);
        dos.writeChar('A');
        byte[] datas = baos.toByteArray();

        //读取
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(datas));
        //顺序保持一致
        String str = dis.readUTF();
        int age = dis.readInt();
        char c = dis.readChar();
        System.out.println(str);System.out.println(age);System.out.println(c);
    }
}
