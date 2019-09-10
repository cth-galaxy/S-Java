package Collection;

import java.util.*;

/**
 * 使用迭代器遍历容器
 * @author: CTH
 **/
public class TestIterator {
    public static void main(String[] args) {
        testListIterator();
        System.out.println("#######################");
        testSetIterator();
        System.out.println("#######################");
        testMapIterator01();
        System.out.println("#######################");
        testMapIterator02();
    }
    public static void testListIterator() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //获取迭代器，hasNext判断下一个是否为空
        for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
            String temp = iterator.next();//next获取当前元素，并指向下一个元素
            System.out.println(temp);
        }
    }
    public static void testSetIterator() {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
            String temp = iterator.next();
            System.out.println(temp);
        }
    }
    public static void testMapIterator01() {
        Map<Integer,String> map = new HashMap<>();
        map.put(10,"A");
        map.put(20,"B");
        map.put(30,"C");
        Set<Map.Entry<Integer,String>> ss = map.entrySet();//获取节点对象
        for (Iterator<Map.Entry<Integer, String>> iterator = ss.iterator(); iterator.hasNext();) {
            Map.Entry<Integer,String> temp = iterator.next();
            System.out.println(temp.getKey()+"-->"+temp.getValue());
        }
    }
    public static void testMapIterator02() {
        Map<Integer,String> map = new HashMap<>();
        map.put(10,"A");
        map.put(20,"B");
        map.put(30,"C");
        Set<Integer> ss = map.keySet();//获取key值
        for (Iterator<Integer> iterator = ss.iterator(); iterator.hasNext();) {
           Integer temp = iterator.next();
            System.out.println(temp+"-->"+map.get(temp));
        }
    }


}
