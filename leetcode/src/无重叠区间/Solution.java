package 无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    Comparator<int[]> cmp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            //比较的是时候也是按照最右边的升序比较
            if(o1[1] > o2[1]) return 1;
            if(o1[1] < o2[1]) return -1;
            else return 0;
        }
    };

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, cmp);
        int result = 1;
        //纪录每个区间的最右边
        int pos = intervals[0][1];
        for(int i = 1; i < intervals.length; ++i){
            //一旦有区间的左边大于当前的最右边
            if(intervals[i][0] > pos){
                pos = intervals[i][1];
                result++;
            }
        }
        int ans = intervals.length-result;
        return ans;
    }
}
