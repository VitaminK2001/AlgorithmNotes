package 数组.最大三角形的面积;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public double largestTriangleArea(int[][] points) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for(int i = 0; i < points.length; ++i){
            x.add(points[i][0]);
            y.add(points[i][1]);
        }
        Collections.sort(x);
        Collections.sort(y);
        return 0;
    }
}


class Solution2 {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ret = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ret = Math.max(ret, triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return ret;
    }

    public double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }
}

//c++
//class Solution3 {
//    public:
//    double largestTriangleArea(vector<vector<int>>& points) {
//        double ans = 0.;
//        for (auto&& p1: points) {
//            for (auto && p2: points) {
//                for (auto && p3: points) {
//                    double x1 = p1[0];
//                    double x2 = p2[0]-x1;
//                    double x3 = p3[0]-x1;
//                    double y1 = p1[1];
//                    double y2 = p2[1]-y1;
//                    double y3 = p3[1]-y1;
//                    double s = abs(x2*y3-x3*y2)/2;
//                    ans = max(ans, s);
//                }
//            }
//        }
//        return ans;
//    }
//};