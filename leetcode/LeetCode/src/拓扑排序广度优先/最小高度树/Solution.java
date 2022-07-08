package 拓扑排序广度优先.最小高度树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>(); //保存最终的结果
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            map.add(new ArrayList<>());
        }
        if(n == 1) {  //如果只有一个结点
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        for(int[] edge: edges){
            degree[edge[0]]++;
            degree[edge[1]]++; //连接的两个点度数都+1
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]); //无向图相邻节点添加
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n; ++i){
            if(degree[i] == 1) que.offer(i);
        }
        while(!que.isEmpty()){
            res = new ArrayList<>();
            int size = que.size();
            for(int i = 0; i < size; ++i){
                int cur = que.poll();
                res.add(cur);  //为了最后存储的是根节点
                List<Integer> neighbors = map.get(cur);
                for(int neighbor: neighbors){
                    degree[neighbor]--;
                    if(degree[neighbor] == 1) que.offer(neighbor);
                }
            }
        }
        return res;
    }
}
