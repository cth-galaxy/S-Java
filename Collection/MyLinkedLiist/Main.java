package Collection.MyLinkedLiist;

/**
 * @author: CTH
 **/
public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list= new MyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        System.out.println(list);
        list.insert(3,"钢铁侠");
        System.out.println(list);
        list.insert(0,"蜘蛛侠");
        System.out.println(list);
        list.insert(7,"蜘蛛侠");
        System.out.println(list);

    }
}
