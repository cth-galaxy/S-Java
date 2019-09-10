package Collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: CTH
 **/
public class TestSet {
    public static void main(String[] args) {
        //set不重复，无序
        Set<String> set = new HashSet<>();
        set.add("问天");
        set.add("轩辕");
        set.add("干将");
        set.add("莫邪");
        set.add("问天");//重复
        System.out.println(set);

    }
}
