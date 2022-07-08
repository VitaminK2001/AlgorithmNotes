//https://leetcode-cn.com/problems/ugly-number-ii/solution/chou-shu-ii-by-leetcode-solution-uoqd/
package 动态规划.丑数2;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int nthUglyNumber(int n) {
        int[] factors = {2,3,5};
        Set seen = new HashSet<Integer>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.add(1L);
        int ugly = 0;
        for(int i = 0; i < n; ++i){
            long cur = heap.poll();
            ugly = (int) cur;
            for(int fac : factors){
                long next = cur*fac;
                if(seen.add(next)){
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}

class Solution2{
    public int nthUglyNumber(int n){
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if(dp[i] == num2){
                p2++;
            }
            if(dp[i] == num3){
                p3++;
            }
            if(dp[i] == num5){
                p5++;
            }
        }
        return dp[n];
    }
}
