package 广度优先.打开转盘锁.双向BFS;

import java.util.*;

//https://leetcode-cn.com/problems/open-the-lock/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-wyr9/
public class Solution {
    Set<String> deadSet = new HashSet<>(); //用来纪录deadEnds
    String t, s; //目标字符串和初始字符串

    public int openLock(String[] deadEnds, String target) {
        s = "0000";
        t = target;
        if(s.equals(t)) return 0;
        deadSet.addAll(Arrays.asList(deadEnds)); //asList的返回值是Arraylist
        if(deadSet.contains(s)) return -1; //不可能完成
        return bfs();
    }

    private int bfs() {
        Deque<String> d1 = new LinkedList<>(); //从s开始
        Deque<String> d2 = new LinkedList<>(); //从t开始
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>(); //同时声明两个HashMap
        d1.add(s);
        m1.put(s,0); //放入开始字符串，标记step = 0
        d2.add(t);
        m2.put(t,0); //放入目标字符串，标记step = 0

        //如果其中一个队列空了没必要往下搜索
        while(!d1.isEmpty() && !d2.isEmpty()){
            int t = -1; //返回值
            if(d1.size() <= d2.size()){
                t = update(d1, m1, m2);
            }else {
                t = update(d2, m2, m1);
            }
            if(t != -1) return t; //已经找到了
        }
        return -1;
    }

    private int update(Deque<String> cur, Map<String, Integer> me, Map<String, Integer> other) {
        int m = cur.size(); //每一个update只更新一层
        while(m-- > 0){ //--m会少查找一轮 所以是m--先比较后-- 先拿n本身的值用于表达式使用，再让n递减
            String poll = cur.poll();
            char[] pcs = poll.toCharArray();
            int step = me.get(poll);
            for(int i = 0; i < 4; ++i){
                for(int j = -1; j <= 1; ++j){
                    if(j == 0) continue;

                    //求替换字符串str
                    int origin = pcs[i]-'0';
                    int next = (origin+j)%10;
                    if(next == -1) next = 9;
                    char[] clone = pcs.clone();
                    clone[i] = (char)(next+'0');
                    String str = String.valueOf(clone);

                    if(deadSet.contains(str)) continue; //死串
                    if(me.containsKey(str)) continue; //已访问过

                    //如果在另一方向找到过
                    if(other.containsKey(str)){
                        return step+1+other.get(str);
                    }else {
                        cur.add(str);
                        me.put(str, step+1);
                    }
                }
            }
        }
        return -1; //这一层没有找到
    }
}
