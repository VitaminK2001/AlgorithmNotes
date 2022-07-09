package 深度优先.跳跃游戏3;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        return dfs(arr, start, n, visited);
    }
    boolean dfs(int[] arr, int idx, int n, boolean[] visited){
        if(idx < 0 || idx >= n || visited[idx]) return false;
        if(arr[idx] == 0) return true;
        visited[idx] = true;
        return (dfs(arr, idx+arr[idx], n, visited) || dfs(arr, idx-arr[idx], n, visited));
    }
}

class Solution2{
    public boolean canReach(int[] arr, int start){
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(start);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; ++i){
                int cur = que.poll();
                if(cur < 0 || cur > n) continue;
                if(arr[cur] == 0) continue;
                visited[cur] = true;
                que.offer(cur+arr[cur]);
                que.offer(cur-arr[cur]);
            }
        }
        return false;
    }
}







