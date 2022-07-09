package 动态规划.两数之和输入有序数组;
//https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n-1;
        while(left < right){
            if (numbers[left]+numbers[right] < target){
                left++;
            }else if(numbers[left]+numbers[right] == target){
                break;
            }
            else{
                right--;
            }
        }
        return new int[]{left+1, right+1};
    }
}
//二分查找
//class Solution2{
//    public int[] twoSum(int[] numbers, int target) {
//        int n = numbers.length;
//        int l = 0; int r = n-1;
//        while(l <= r){
//            int mid = (r-l)/2 + l;
//            if(numbers[mid] > target - numbers[l]){
//            }
//        }
//    }
//}
