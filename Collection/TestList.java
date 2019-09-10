package Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: CTH
 **/
public class TestList {
    public static void main(String[] args) {
        //list可重复，有序（有下标索引）
        List<String> list = new ArrayList<>();
        list.add("钢铁侠");
        list.add("美国队长");
        list.add("雷神");
        list.add("超人");
        System.out.println(list);
        list.add(2,"蜘蛛侠");
        System.out.println(list);
        System.out.println(list.indexOf("钢铁侠"));
        list.add("钢铁侠");
        System.out.println(list.lastIndexOf("钢铁侠"));
        System.out.println(list);

    }
}
