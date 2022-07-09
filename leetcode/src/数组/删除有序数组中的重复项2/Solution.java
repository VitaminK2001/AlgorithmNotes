//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
package 数组.删除有序数组中的重复项2;

class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int fast = 2;
        int slow = 2;
        while(fast < n){
            if(nums[slow-2] != nums[fast]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
