package 加油站;

import com.sun.nio.sctp.AbstractNotificationHandler;

import javax.swing.*;
import java.util.*;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; ++i){
            int rest = gas[i] - cost[i];
            int index = (i+1)%gas.length; //这个时候已经出发了
            while(rest > 0 && index != i){
                rest += gas[index] - cost[index];
                index = (index+1) % gas.length;
            }
            if(rest >= 0 && index == i) return i;
        }
        return -1;
    }
}
class Solution2{
    public int canCompleteCircuit(int[] gas, int[] cost){
        int n = gas.length;
        int i = 0;
        while (i < n){
            int sumOfGas = 0;
            int sumOfCost = 0;
            int count = 0;
            while(count < n){
                int j = (i+count)%n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if(sumOfCost > sumOfGas) break;
                count++;
            }
            if(count == n) return i;
            i = i+count+1;
        }
        return -1;
    }
}
class Solution3{
    public int canCompleteCircuit(int[] gas, int[] cost){
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < len; ++i){
            spare += gas[i]-cost[i];
            if(spare < minSpare){
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex+1)%len;
    }
}
class Student implements Comparable<Student>{
    private int age;
    private int seat;
    private double grades;
    @Override
    public int compareTo(Student o1){
        return (int) (this.getGrades() - o1.getGrades());

        /*if(this.getGrades() - o1.getGrades() > 0) return 1;
        else return -1;*/ /*不要这样写*/
        /*这样写1.搞不清升降序，2.没有0的情况*/
    }
    @Override
    public boolean equals(Object o1){
        if(this == o1) return true;
        if(this.getClass() == o1.getClass()) return true;
        return this.getAge() == ((Student)o1).getAge();
    }
    @Override
    public int hashCode(){
        return this.age;
    }
    public Student(int age, int seat, double grades){
        this.age = age;
        this.seat = seat;
        this.grades = grades;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }
}
class asap {
    public static void main(String[] args) {
        Map<Student, String> map = new TreeMap<>();
        Student a = new Student(10,1, 80.0);
        Student b =  new Student(10,2, 76.7);
        Student c = new Student(10,3, 99.1);
        map.put(a, "Jack");
        map.put(b, "Jay");
        map.put(c, "Micheal");
        System.out.println(map.containsKey(a));
        System.out.println(map.get(a));

        /*按照对值*/
        for(Map.Entry e: map.entrySet()){
            System.out.println("value=" + e.getValue());
            System.out.println("key=" + e.getKey());
        }
        /*按照键*/
        for(Student s: map.keySet()){
            System.out.println(map.get(s));
        }
        /*按照值*/
        for(String s: map.values()){
            System.out.println(s);
        }
        /*按照迭代器*/
        Set set = map.entrySet();
        for(Iterator it= set.iterator(); it.hasNext();){
            Map.Entry e = (Map.Entry) it.next();
            e.getKey();
            e.getValue();
        }
        Set<Student> Stu = map.keySet();

        Iterator<Student> iterator = Stu.iterator();
        while(iterator.hasNext()){
            Student next = iterator.next();
            System.out.println(map.get(next));
            int curAge = next.getAge();
            int curSeat = next.getSeat();
            System.out.println(curAge+" "+curSeat+" "+map.get(next));
        }

        TreeSet<Student> treeSet = new TreeSet<>();
        Student d = new Student(10, 4, 100.0);
        treeSet.add(d);
        System.out.println(treeSet.contains(d));

        HashMap<Student, String> hashMap = new HashMap<>();
        hashMap.put(a, "Jack");
        hashMap.put(b, "Jay");
        hashMap.put(c, "Micheal");
        System.out.println(hashMap.containsKey(d));
        double dbNum = 10.0;
        System.out.println(Double.valueOf(dbNum).hashCode());
        //1076101120：内存地址没有@符号，但是转换成了int值
        System.out.println(a.hashCode());
        //10重写了hashCode方法之后对象改变
        String s = new String();
        Object o = new Object();
        System.out.println(s.getClass() == o.getClass());
        //false：类型比较
        System.out.println(s instanceof String);
        //true：实例是从属关系
        System.out.println(s instanceof Object);
        //true：实例是从属关系

        int[] arrays = {1,2,3,5,7,3,4,5};


    }
}
class Game implements Comparable{
    Integer players;
    String date;
    @Override
    public int compareTo(Object o){
        return this.players.compareTo(((Game)o).players);
    }
    public Game(){

    }
    public Game(int players, String date){
        this.date = date;
        this.players = players;
    }

    public static void main(String[] args) {
        Game[] games = new Game[3];
        Game punish = new Game(1, "2022.1.23");
        Game banG = new Game(5, "2020.10.8");
        Game csgo = new Game(2, "2020.1.20");
        games[0] = punish;
        games[1] = banG;
        games[2] = csgo;
        Arrays.sort(games);
        for(Game e : games){
            System.out.println(e.date);
            /*2022.1.23
              2020.1.20
              2020.10.8*/
        }
    }
}
