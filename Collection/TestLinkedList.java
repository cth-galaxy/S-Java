package Collection;

import java.util.LinkedList;

/**
 * 测试节点链表常用方法
 * @author: CTH
 **/
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        list.add("喜羊羊");
        list.add("沸羊羊");
        list.add("美羊羊");
        list.add("懒羊羊");
        list.add("刀羊");
        list.add("灰太狼");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(4));
        System.out.println(list.remove(5));
        list.add(5,"蕉太狼");
        System.out.println(list);
    }
}
