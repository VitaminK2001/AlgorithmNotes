package 二分查找.寻找两个正序数组的中位数;
//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n == 0){
            if(m != 0){
                if(m % 2 == 0){
                    return (nums2[m/2-1]+nums2[m/2])/2.0;
                }else{
                    return nums2[m/2];
                }
            }
        }
        if(m == 0){
            if(n != 0){
                if(n % 2 == 0){
                    return (nums1[n/2-1]+nums1[n/2])/2.0;
                }
            }else{
                return nums1[n/2];
            }
        }

        int i = nums1[0];
        int j = nums2[0];
        int[] res = new int[n+m];
        int count = 0;
        while(count != n+m) {
            if (i == n) {
                while (j != m) {
                    res[count++] = nums2[j++];
                }
                break;
            }
            if (j == m) {
                while (i != n) {
                    res[count++] = nums1[i++];
                }
                break;
            }
        }

        if(nums1[i] < nums2[j]){
            res[count++] = nums1[i++];
        }else{
            res[count++] = nums2[j++];
        }

        if((count)%2 == 0) return (res[(n+m)/2-1]+res[(n+m)/2]) / 2.0;
        else return res[(n+m)/2];
    }
}
