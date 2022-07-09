package 分发糖果2;

public class Solution {
    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        int result = 0;
        for(int i = 1; i < ratings.length; ++i){
            if(ratings[i]>ratings[i-1]) candyVec[i] = candyVec[i-1]+1;
        }
        for(int i = ratings.length-2; i >= 0; --i){
            if(ratings[i]>ratings[i+1]) candyVec[i] = Math.max(candyVec[i+1]+1, candyVec[i]);
        }
        for(int i = 0; i < ratings.length; ++i){
            result += candyVec[i];
        }
        result += ratings.length;
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.candy(new int[]{1,2,87,87,87,2,1}));
    }
}
