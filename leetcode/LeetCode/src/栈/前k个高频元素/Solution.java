package 栈.前k个高频元素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>(); //出现的次数
        for(int num : nums){
            occurrences.put(num, occurrences.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] m, int[] n){
                return m[1] - n[1];
            }
        });

        for(Map.Entry<Integer, Integer> entry : occurrences.entrySet()){
            int num = entry.getKey(), count = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            }else{
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for(int i = 0; i < k; ++i){
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
