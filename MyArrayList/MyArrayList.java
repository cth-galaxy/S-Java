package Collection;

/**
 * 手工实现ArrayList
 * @author: CTH
 **/
public class MyArrayList<E> {
    private Object[] elementData;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    /**
     * 构造方法(无参)
     */
    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 构造方法(有参)
     * @param capacity
     */
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            System.out.println("容量不能为负数");
        }else if (capacity == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        }else {
            elementData = new Object[capacity];
        }
    }

    /**
     * 返回实际大小
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 添加元素
     * @param element
     */
    public void add(E element) {
        elementData[size++] = element;
        //自动扩容数组
        //何时扩容？
        if (size == elementData.length) {
            //怎么扩容？
            Object[] newArray = new Object[elementData.length + (elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
    }

    /**
     * 添加元素
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        //a,c,d,e,f
        //a,b,c,d,e,f
        if (index < size) {
            System.arraycopy(elementData, index, elementData, index + 1, size - index);
            elementData[index] = element;
            size++;
        }else {
            this.add(element);
        }
    }

    /**
     * 获取元素
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return (E)elementData[index];
    }

    /**
     * 设置元素
     * @param index
     * @param element
     */
    public void set(int index, E element) {
        rangeCheck(index);
        elementData[index] = element;
    }

    /**
     * 移除元素
     * @param element
     */
    public void remove(E element) {
        for (int i=0; i<size; i++) {
            if (element.equals(elementData[i])) {
                get(i);
                remove(i);
            }
        }
    }

    /**
     * 移除操作
     * @param index
     */
    public void remove(int index) {
        rangeCheck(index);
        //a,b,c,d,e
        //a,c,d,e
        if (index < size-1) {
            System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        }
        elementData[size-1] = null;
        size--;
    }

    /**
     * 打印数组-->重写toString方法
     * @return
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i=0; i<size; i++) {
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    /**
     * 越界检查
     * @param index
     */
    private void rangeCheck(int index) {
        if (index<0 || index>size-1) {
            throw new RuntimeException("索引不合法，索引："+index);
        }
    }
}

