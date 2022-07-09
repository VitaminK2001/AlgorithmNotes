package 二分查找.寻找右区间;

import java.util.Arrays;

public class BiSearch {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,6,8,5,9,32,90};
        System.out.println(BiSearch(nums, 8));
    }

    /**
     * 实现要找的比target尽可能的小的数字
     * @param nums
     * @param target
     */
    public static int BiSearch(int[] nums, int target){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1;
        int index = -1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] >= target){
                right = mid-1;
            }
            else{
                index = mid;
                left = mid+1;
            }
        }
        return nums[index];
    }
}
