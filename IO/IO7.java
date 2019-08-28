package IO;

import java.io.*;
import java.util.Date;

/**
 * 对象流
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * 3、不是所有对象都可以序列化，该对象必须实现Serializable接口
 * @author: CTH
 **/
public class IO7 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {//也可以选用文件，这是使用字节数组
        //写出-->序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject("难上加难");
        oos.writeObject(new Date());
        oos.writeObject(new Student("德莱厄斯",22,"篮球"));
        byte[] datas = baos.toByteArray();
        //读取-->反序列化
       ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(datas));
       //反序列化后，对象的类别丢失，统一为Object对象
       Object ostr = ois.readObject();
       Object odate = ois.readObject();
       Object ostudent = ois.readObject();
       //通过判断，强制类型转换，找到对象类型
       if (ostr instanceof String) {
           String str = (String)ostr;
           System.out.println(str);
       }
        if (odate instanceof Date) {
            Date date = (Date) odate;
            System.out.println(date);
        }
        if (ostudent instanceof Student) {
            Student student = (Student) ostudent;
            System.out.println("姓名:"+student.getName()+";年龄:"+student.getAge()+";专业:"+student.getMajor());
        }
    }
}
class Student implements java.io.Serializable {//实现Serializable接口
    private String name;
    private int age;
    private String major;

    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }
}
