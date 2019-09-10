package Collection.MyHashMap;

/**
 * @author: CTH
 **/
public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer,String> hm = new MyHashMap<>();
        hm.put(10,"A");
        hm.put(20,"B");
        hm.put(40,"C");
        hm.put(53,"D");
        hm.put(69,"E");
        hm.put(85,"F");
        hm.put(100,"A");
        hm.put(101,"B");
        hm.put(102,"C");
        hm.put(103,"D");
        hm.put(104,"E");
        hm.put(105,"F");
        hm.put(106,"A");
        hm.put(107,"B");
        hm.put(108,"C");
        hm.put(109,"D");
        hm.put(110,"E");
        hm.put(111,"F");
        hm.put(112,"A");

        System.out.println(hm);
        System.out.println(hm.get(69));
        System.out.println(hm.get(112));
    }
}
