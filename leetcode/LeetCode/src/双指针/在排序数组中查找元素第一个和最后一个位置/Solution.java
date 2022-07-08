package 双指针.在排序数组中查找元素第一个和最后一个位置;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = lowerBound(nums, target);
        int upper = upperBound(nums, target)-1;
        //注意会有出错情况
        if(lower > nums.length || nums[lower] != target) return new int[]{-1,-1};
        return new int[]{lower, upper};

    }
    public int lowerBound(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int r = n;
        int mid;
        while(l < r){
            mid = l + (r-l)/2;
            if(nums[mid] >= target){
                r = mid;
            }else {
                ++l;
            }
        }
        return l;
    }
    public int upperBound(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int r = n;
        int mid;
        while(l < r){
            mid = l + (r-l)/2;
            if(nums[mid] > target){
                r = mid; //保证了r是第一个上界
            }else {
                ++l;
            }
        }
        return l;
    }
}
