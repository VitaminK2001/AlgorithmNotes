package 贪心.摆动序列;
//https://leetcode-cn.com/problems/wiggle-subsequence/
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;
        int curDiff = 0;
        int preDiff = 0;
        int result = 1;
        for(int i = 0; i < len; ++i){
            curDiff = nums[i+1]-nums[i];
            if((curDiff>=0 && preDiff<0) || (curDiff< 0 && preDiff>=0)){
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}

//波动才会带来改变，如果一直都是上升或者下降，则值实际上是不变的，相等的情况也是这样
class Solution2{
    public int wiggleMaxLength(int[] nums) {
        int up = 1;
        int down = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i-1] > nums[i]) down = up + 1;
            if(nums[i-1] < nums[i]) up = down + 1;
        }
        return Math.max(up, down);
    }
}
