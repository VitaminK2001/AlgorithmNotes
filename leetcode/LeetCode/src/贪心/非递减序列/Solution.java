package 贪心.非递减序列;
//https://leetcode-cn.com/problems/non-decreasing-array/
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 1; i < n; ++i){
            if(count > 1) return false;
            if(i == 1 && nums[i-1] > nums[i]){
                count++;
                nums[i-1] = nums[i];
            }
            else if(nums[i-1]>nums[i]){
                count++;
                if(count > 1) return false;
                if(nums[i-2] > nums[i]){
                    nums[i] = nums[i-1];
                }
                if(nums[i-2] <= nums[i]){
                    nums[i-1] = nums[i];
                }
            }
        }
        return true;
    }
}
