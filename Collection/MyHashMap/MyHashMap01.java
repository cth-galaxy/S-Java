package Collection.MyHashMap;

/**
 * 手写简易HashMap
 * @author: CTH
 **/
public class MyHashMap01 {
    private Node[] table;//位桶数组
    private int size;

    /**
     * 构造方法
     */
    public MyHashMap01() {
        table = new Node[16];//一般为2的幂次大小
    }

    /**
     *
     * @param v
     * @param length
     * @return
     */
    public int myHash(int v, int length) {
        return v&(length-1);

    }
    /**
     * 放置键值对
     * @param key
     * @param value
     */
    public void put(Object key, Object value) {
        Node newNode = new Node();
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node itelast = null;//遍历的最后一个节点
        boolean keyRepeat = false;//key值是否重复
        Node temp = table[newNode.hash];
        if (temp == null) {
            //该数组位置无元素，直接放
            table[newNode.hash] = newNode;
        }else {
            //节点元素不为空，则遍历对应链表
            while (temp != null) {
                if (temp.key.equals(key)) {
                    //key值重复，替换内容
                    keyRepeat = true;
                    temp.value = newNode.value;//其它值（hash，key，next）相同，不需要替换
                    break;
                }else {
                    //key值不重复，向链表后面添加
                    itelast = temp;
                    temp = temp.next;
                }
            }
            if (!keyRepeat) {
                itelast.next = newNode;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap01 h = new MyHashMap01();
        h.put(10, "A");
        h.put(20, "B");
        h.put(30, "D");
        h.put(30, "C");

        h.put(53, "E");
        h.put(69, "F");
        h.put(85, "G");
        System.out.println(h);
    }

}
