package Divide_and_Conquer;
import java.io.*;
import java.util.*;

public class 最优解 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        double[] nums  = new double[n];
        for(int i = 0; i < n; ++i){
            nums[i] = in.nextDouble();
        }
        System.out.printf("%.2f\n", Math.floor(solve(nums, k) * 100) / 100);
    }
    public static double solve(double[] nums, int k){
        double lb = 0.00, ub = 10e5 + 0.01;
        for(int i = 0; i < 100; i++){ //通过100次二分精度可以达到10的30次方
            double mid = lb + (ub - lb)/2;
            if(c(nums, mid, k)){
                lb = mid; //可以切出k条绳子，提高每条绳子的长度
            }else{
                ub = mid; //不能切出k条绳子，降低每条绳子的长度
            }
        }
        return lb;
    }
    public static boolean c(double[] nums, double seg, int k){
        int count = 0;
        for(double num : nums){
            count += Math.floor(num / seg);
        }
        return count >= k;
    } // 判断能否切出k条长度均为seg的绳子

}
