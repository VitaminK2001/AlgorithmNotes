package 深度优先.最小基因变化;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;

public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> cnt = new HashSet<>(Arrays.asList(bank));
        char[] set = {'A', 'C', 'G', 'T'};
        if(!cnt.contains(end)){
            return -1;
        }
        if(start.equals(end)){ //String的equals
            return 0;
        }
        Queue<String> queue = new ArrayDeque<>();
        int step = 1;
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int size = queue.size(); //如果在下面写queue.size()其实每一轮都会变的
            for(int i = 0; i < size; ++i){
                String s = queue.poll();
                for(int idx = 0; idx < 8; ++idx){
                    for(int key = 0; key < 4; ++key){
                        if(set[key] != s.charAt(idx)){
                            StringBuffer sb = new StringBuffer(s);
                            sb.setCharAt(idx, set[key]);
                            String next = sb.toString();
                            if(!visited.contains(next) && cnt.contains(next)){
                                if(next.equals(end)){
                                    return step;
                                }
                                queue.offer(next);
                                visited.add(next);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
