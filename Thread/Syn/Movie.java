package Thread.Syn;

import java.util.ArrayList;
import java.util.List;

/**
 * 同步实例：电影院买票
 * @author: CTH
 **/
public class Movie {
    public static void main(String[] args) {
        List<Integer> available = new ArrayList<>(7);
        for (int i=1; i<8; i++) {
            available.add(i);
        }
        Cinema cinema = new Cinema("GalaxyCiname", available);
        List<Integer> seats1 = new ArrayList<>();
        List<Integer> seats2 = new ArrayList<>();
        seats1.add(1);
        seats1.add(3);
        seats1.add(5);
        seats2.add(2);
        seats2.add(4);
        seats2.add(5);
        new Thread(new Customer(cinema, seats1, "张三")).start();
        new Thread(new Customer(cinema, seats2, "李四")).start();
    }
}
class Cinema {
    String name;
    List<Integer> available;//可用位置

    public Cinema(String name, List<Integer> available) {
        this.name = name;
        this.available = available;
    }
}
class Customer implements Runnable {
    Cinema cinema;//电影院
    List<Integer> seats;//选购的座位
    String name;

    public Customer(Cinema cinema, List<Integer> seats, String name) {
        this.cinema = cinema;
        this.seats = seats;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);//网络延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean flag = bookTickets(cinema, seats);
        if (flag) {
            System.out.println("出票成功!"+name+",您已订购"+cinema.name+"票数"+seats.size()+"张--<位置为"+ seats);
        }else {
            System.out.println("出票失败！" +cinema.name+ "位置不够");
        }
    }
    public synchronized boolean bookTickets(Cinema cinema, List<Integer> seats) {
    List<Integer> temp = new ArrayList<>();
    temp.addAll(cinema.available);//拷贝一份原始数据
    temp.removeAll(seats);//从可用位置减去订购位置
    if (cinema.available.size()-temp.size() != seats.size()) {
        return false;//大小不一致，说明有订购的票中部分票没有出票
    }
    cinema.available = temp;
    return true;
    }
}