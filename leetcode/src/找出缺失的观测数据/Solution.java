package 找出缺失的观测数据;

import java.util.Arrays;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        //mean是平均值，n是缺失的数量，rolls是已有的观测值 值从1~6
        int m = rolls.length;
        int sum = mean * (m+n);
        int sumM = 0;
        int[] res = new int[n];
        for(int roll : rolls){
            sumM += roll;
        }
        int sumN = sum - sumM;
        if(sumN > 6*n || sumN < n) return new int[]{};
        int average = sumN / n;
        Arrays.fill(res, average);
        int gap = sumN-n*average;
        for(int i = 0; ; ++i) {
            if (gap == 0) break;
            if (res[i] < 6) {
                res[i]++;
                gap--;
            }
        }
        return res;
    }
}
