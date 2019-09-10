package Collection.MyLinkedLiist;

/**
 * @author: CTH
 **/
public class Node {
    public Node previous;//前一个结点
    public Node next;//后一个节点

    public Object elementData;//数据

    public Node(Node previous, Node next, Object elementData) {
        this.previous = previous;
        this.next = next;
        this.elementData = elementData;
    }

    public Node(Object elementData) {
        super();
        this.elementData = elementData;
    }
}
