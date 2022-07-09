package 双指针.平方数之和;

public class Solution {
    public boolean judgeSquareSum(int c) {
        for(long a = 0; a * a <= c; ++a){
            double b = Math.sqrt(c-a*a);
            if(b == (int)b){
                return true;
            }
        }
        return false;
    }
}
//双指针
class Solution2{
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c-left*left);
        while(left <= right){
            long sum = left*left + right*right;
            if(c == sum){
                return true;
            }
            else if(c > sum){
                ++left;
            }
            else{
                --right;
            }
        }
        return false;
    }
}
