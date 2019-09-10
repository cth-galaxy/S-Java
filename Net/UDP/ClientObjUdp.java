package Net.UDP;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**客户端
 * 1、使用DatagramSocket 指定端口，创建发送端
 * 2、准备数据，一定要将数据转换为字节数组
 * 3、封装成DatagramPacket包裹，需指定目的地
 * 4、发送包裹 send（DatagramPacket p）
 * 5、释放资源
 * @author: CTH
**/
public class ClientObjUdp {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动。。。。。");
        // 1、使用DatagramSocket 指定端口，创建发送端
        DatagramSocket client = new DatagramSocket(9998);//发送端端口
        // 2、准备数据，一定要将数据转换为字节数组
        //对象转为字节数据（序列化）
        //注意该对象必须实现Serializable接口
        Person p = new Person("马云",54,"阿里");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos= new ObjectOutputStream(new BufferedOutputStream(baos));
        oos.writeObject(p);
        oos.flush();
        byte[] datas = baos.toByteArray();
        // 3、封装成DatagramPacket包裹，需指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost",9999));
        // 4、发送包裹 send（DatagramPacket p）
        client.send(packet);
        // 5、释放资源
        client.close();
    }
}

class Person implements Serializable {
    String name;
    int age;
    String company;

    public Person(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    @Override
    public String toString() {
        return this.name +" "+this.age+" "+this.company;
    }
}
