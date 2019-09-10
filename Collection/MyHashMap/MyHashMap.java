package Collection.MyHashMap;

/**
 * @author: CTH
 **/
public class MyHashMap<K,V> {
    private Node[] table; //位桶数组
    private int size;
    /**
     * 构造方法
     */
    public MyHashMap() {
        table = new Node[16];//安位取余。一般设长度为2的幂次
    }

    /**
     * 计算hash值，由hash值确定数组位置
     * @param v
     * @param length
     * @return hash
     */
    public int myHash(int v, int length) {
        return v&(length-1);//返回由键值（key）的哈希码计算的到的hash值
    }

    /**
     * 添加元素
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (size > table.length*0.75) {
            //自动扩容
            Node[] tempTable = new Node[table.length*2];
            System.arraycopy(table,0,tempTable,0,table.length);
            table =tempTable;
        }
        Node newNode = new Node();//添加的新节点
        newNode.hash = myHash(key.hashCode(), table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        Node temp = table[newNode.hash];
        Node itelast = null; //正在遍历链表的最后一个节点
        boolean keyRepeat = false;//key值是否重复
        if (temp == null) {
            //该列（数组列）没有元素，直接添加新的节点
            table[newNode.hash] = newNode;
            size++;
        }else {
            //有元素，遍历该列的节点
            while (temp != null) {
                if (temp.key.equals(newNode.key)) {
                    //key值重复，替换内容
                    keyRepeat = true;
                    temp.value = newNode.value;//hash,key,next不需要改变
                    break;
                } else {
                    itelast = temp;
                    temp = temp.next;
                }
            }
            if (!keyRepeat) {
                //不重复，在最后一个节点后面添加新节点
                itelast.next = newNode;
                size++;
            }
        }
    }

    /**
     * 获得对应键值对的值
     * @param key
     * @return
     */
    public V get(K key) {
        int hash = myHash(key.hashCode(), table.length);
        Node temp = table[hash];
        V value = null;
        while (temp != null) {
            if (temp.key.equals(key)) {
                value = (V) temp.value;
            }
            temp = temp.next;
        }
        return value;
    }
    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("{");
        for (int i=0; i<table.length; i++) {
            Node temp = table[i];
            while (temp != null) {
                sb.append(temp.key+":"+temp.value+", ");
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();
    }
}
