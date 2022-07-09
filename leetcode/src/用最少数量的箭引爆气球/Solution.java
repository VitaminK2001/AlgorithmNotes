package 用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    Comparator<int[]> cmp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] > o2[0]) return 1;
            if(o1[0] == o2[0]) return 0;
            else return -1;
        }
    };
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, cmp);
        int result = 1;
        int cover = points[0][1];
        for(int i = 1; i < points.length; ++i){
            if(points[i][0] > cover){
                cover = points[i][1];
                result++;
            }
        }
        return result;
    }
}
