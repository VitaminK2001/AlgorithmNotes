package 优先队列.找到处理最多的请求的服务器;

import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();
        for(int i = 0; i < k; ++i){
            available.add(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0]-o2[0];
                    }
                }
        );
        int[] request = new int[k]; //存放请求次数
        for(int i = 0; i < arrival.length; ++i){
            while(!busy.isEmpty() && busy.peek()[0] <= arrival[i]){
                available.add(busy.poll()[1]);
            }
            if(available.isEmpty()){
                continue; //没有可以处理的服务器
            }
            Integer p = available.ceiling(i%k);
            if(p == null){
                p = available.first();
            }
            request[p]++;
            busy.offer(new int[]{arrival[i]+load[i], p});
            available.remove(p);
        }
        int maxRequest = Arrays.stream(request).max().getAsInt();
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < k; ++i){
            if(request[i] == maxRequest){
                ret.add(i);
            }
        }
        return ret;
    }
}
