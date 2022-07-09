package 双指针.合并两个有序数组;
//https://leetcode-cn.com/problems/merge-sorted-array/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m-- + n-- - 1; //pos是合并后的数组最后一个位置
        while(m >= 0 && n >= 0){
            nums1[pos] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while(n >= 0){
            nums1[pos] = nums2[n--];
        }
    }
    //这里我们使用了 ++ 和--的小技巧:a++ 和 ++a 都是将 a 加 1,
    //但是 a++ 返回值为 a,而++a 返回值为 a+1。
    //如果只是希望增加 a 的值,而不需要返回值,则推荐使用 ++a,其运行速度会略快一些。
}
