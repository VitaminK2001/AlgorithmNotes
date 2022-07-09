package 二分查找.寻找右区间;

import java.util.Arrays;

/**
 * 本题不要求找到相等的，只要求越小越好，是二分查找的变形
 * 写个小例子在bisearch中
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[][] startIndex = new int[intervals.length][2];
        for(int i = 0; i < intervals.length; ++i){
            startIndex[i][0] = intervals[i][0];
            startIndex[i][1] = i;
        }
        Arrays.sort(startIndex, (o1, o2) -> o1[0]-o2[0]);
        int[] ans = new int[intervals.length];
        for(int i = 0; i < intervals.length; ++i){
            int left = 0;
            int right = intervals.length-1;
            int target = -1;
            while(left <= right){
                int mid = (left+right)/2;
                if(startIndex[mid][0] >= intervals[i][1]){
                    target = startIndex[mid][1];
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            ans[i] = target;
        }
        return ans;
    }
}
