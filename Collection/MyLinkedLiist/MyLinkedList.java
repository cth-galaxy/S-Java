package Collection.MyLinkedLiist;

/**
 * @author: CTH
 **/
public class MyLinkedList<E> {
    private Node first;//第一个
    private Node last; //最后一个
    private int size; //元素个数

    /**
     * 添加元素
     * @param element
     */
    public void add(E element) {
        //a,b,c,
        Node node = new Node(element);//创建新节点
        if (first == null) {

            first = node;
            last = node;
        }else {
            //连接新元素的节点
            node.previous = last;
            node.next = null;
            //last的下一个节点链接到新加的元素
            last.next = node;
            last = node;//更新last
        }
        size++;
    }

    /**
     * 返回该索引处的节点对象
     * @param index
     * @return
     */
    private Node getNode(int index) {
        rangeCheck(index);
        Node temp = null;
        if (index <= (size>>1)) {
            temp = first;
            for (int i=0; i<index; i++) {
                temp = temp.next;
            }
        } else {
            temp = last;
            for (int i=size-1; i>index; i++) {
                temp = temp.previous;
            }
        }
        return temp;
    }

    /**
     * 获取该索引处的值
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        Node temp = getNode(index);
        return (E)temp.elementData;
    }

    /**
     * 移除元素
     * @param index
     */
    public void remove(int index) {
        rangeCheck(index);
        Node temp = getNode(index);
        Node up = null;
        Node down= null;
        if (temp != null) {
            if (index == 0) {
                first = down;
            }else if (index == size-1) {
                last = up;
            }else {
                up = temp.previous;
                down = temp.next;
                if (up != null) {
                    up.next = down;
                }
                if (down != null) {
                    down.previous = up;
                }
            }

        }
        size--;
    }

    /**
     * 在链表中插入元素
     * @param index
     * @param element
     */
    public void insert(int index, E element) {
        rangeCheck(index);
        Node temp = getNode(index);
        Node newNode = new Node(element);
        if (temp != null) {
            if (index == 0) {
                first = newNode;
                newNode.next = temp;
                temp.previous = newNode;
            }else if (index == size-1) {
                last = newNode;
                newNode.previous = temp;
                temp.next = newNode;
            }else {
                //找到前一个
                Node up = temp.previous;
                //将新的节点与前一个节点连接
                up.next = newNode;
                newNode.previous = up;
                //将新的节点与插入位置的节点连接
                newNode.next = temp;
                temp.previous = newNode;
            }
        }

        size++;
    }
    private void rangeCheck(int index) {
        if (index<0 || index>size-1) {
            throw new RuntimeException("索引不正确！ 索引："+index);
        }
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        Node temp = first;
        while(temp != null) {
            sb.append(temp.elementData+",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1, ']');
        return sb.toString();
    }
}
