package Collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: CTH
 **/
public class TestMap02 {
    public static void main(String[] args) {
        Employee e1 = new Employee(1001,"小爱",7000);
        Employee e2 = new Employee(1002,"小艺",9000);
        Employee e3 = new Employee(1003,"Sir",10000);
        Map<Integer,Employee> map = new HashMap<>();
        //键值相同会覆盖
        map.put(1001, e1);
        map.put(1002, e2);
        map.put(1003, e3);
        System.out.println(map);
        System.out.println(map.get(1002));
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "id:"+this.getId()+";姓名:"+this.getName()+";薪资:"+this.getSalary();
    }
}
