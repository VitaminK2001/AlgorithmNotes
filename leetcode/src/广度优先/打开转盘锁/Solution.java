package 广度优先.打开转盘锁;
//https://leetcode-cn.com/problems/open-the-lock/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-wyr9/
import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet();
        for(String dead:deadends){
            deads.add(dead);
        }
        q.offer("0000");
        visited.add("0000");
        int step = 0; //从根节点开始

        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; ++i){
                String cur = q.poll();
                //判断是否为死路
                if(deads.contains(cur)) continue;
                if(cur.equals(target)) return step;

                for(int j = 0; j < 4; ++j){
                    String ups = up(cur, j);
                    String downs = down(cur, j);
                    if(!visited.contains(ups)){
                        q.offer(ups);
                        visited.add(ups);
                    }
                    if(!visited.contains(downs)){
                        q.offer(downs);
                        visited.add(downs);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String up(String cur, int j) {
//        if(cur.charAt(j) == '9') cur.charAt(j) = '0'; //不能直接修改字符串
        char[] c = cur.toCharArray();
        if(c[j] == '9') c[j] = '0';
        else c[j]++;
        return new String(c);
    }
    private String down(String cur, int j){
        char[] c = cur.toCharArray();
        if(c[j] == '0') c[j] = '9';
        else c[j]--;
        return new String(c);
    }
}
