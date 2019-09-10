package Collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Map(键值对存储)常用方法
 * @author: CTH
 **/
public class TestMap01 {
    public static void main(String[] args) {
        //map（接口）是抽象父类，HashMap是实现子类
        Map<Integer,String> m1 = new HashMap<>();
        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");
        System.out.println(m1);
        System.out.println(m1.size());
        System.out.println(m1.get(2));
        m1.remove(3);
        System.out.println(m1);
        Map<Integer,String> m2 = new HashMap<>();
        m2.put(4,"四");
        m2.put(5,"五");
        m2.put(6,"六");
        m1.putAll(m2);
        m1.remove(3);
        System.out.println(m1);
    }
}
