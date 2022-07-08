package 二分查找.爱吃香蕉的珂珂;

import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int low = 1;
        int high = piles[piles.length-1];
        if(h == piles.length) return high;
        while(low < high){
            int mid = (low + high) >> 1;
            if(cnaEat(piles, mid, h)){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    public boolean cnaEat(int[] piles, int speed, int h){
        int sum = 0;
        for(int pile : piles){
            sum += Math.ceil(pile*1.0 / speed);
        }
        return sum > h;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(1.2));
        System.out.println(Math.floor(1.2));
    }
}