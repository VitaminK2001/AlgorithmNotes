package 堆排序.优先队列.前k个高频元素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //建立优先队列，维护堆顶元素最小，也就是升序排列
        //用Map存储数组中的数组和对应出现的次数 occurrence
        //每次将Map中的键值对取出
        //如果当前队列的元素个数达到k，则比较，如果键值对的值大于堆顶元素，则移走堆顶元素
        //如果键值对的值小于，说明队列中至少有k个大于键值对的值的数，则舍弃该键值对
        //如果队列中的元素个数没有达到k则直接放入队列
        Map<Integer, Integer> occurrences = new HashMap<>();
        for(int num: nums){
            occurrences.put(num, occurrences.getOrDefault(num, 0)+1);
        }
        //第一个元素表示nums中的数字，第二个元素表示该数字出现的次数
        PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(Map.Entry<Integer, Integer> entry : occurrences.entrySet()){
            int num = entry.getKey(), count = entry.getValue();
            if(que.size() == k){
                if(que.peek()[1] < count){
                    que.poll();
                    que.offer(new int[]{num, count});
                }
            }else {
                que.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for(int i = 0; i < k; ++i){
            ret[i] = que.poll()[0];
        }
        return ret;
    }
}
