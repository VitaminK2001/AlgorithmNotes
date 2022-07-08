package 合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    Comparator<int[]> cmp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] < o2[0]) return -1;
            if(o1[0] > o2[0]) return 1;
            else return 0;
        }
    };
    public int[][] merge(int[][] intervals) {
        int right, left;
        int len = intervals.length;
        if(len == 1) return intervals;
        Arrays.sort(intervals, cmp);
        List<int[]> result = new ArrayList<>();
        left = intervals[0][0];
        right = intervals[0][1];
        for(int i = 1; i < len; ++i){
            if(right >= intervals[i][0]){
                right = Math.max(right, intervals[i][1]);
                if(i == len-1) result.add(new int[]{left, right});
            }else{
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
                if(i == len-1) result.add(new int[]{left,right});
            }
        }
        int[][] res = new int[result.size()][2];
        return result.toArray(res);
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        s.merge(new int[][]{{1,4}, {4,5}});
    }
}
