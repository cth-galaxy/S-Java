package Collection;

/**
 * @author: CTH
 **/
public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(10);
        for (int i=0; i<30; i++) {
            list.add("熊"+i);
        }
        System.out.println(list);
        list.remove(1);
        list.remove("熊2");
        System.out.println(list);
        list.add(1,"熊1");
        list.add(2,"熊2");
        list.add(0,"熊大");
        list.add(31,"熊二");
        System.out.println(list);
        //打印方法调用了String.valueOf()方法，而该方法调用obj.toString()方法，
        // 所有类继承Object，重写调用重写的toString方法
    }
}
