package 哈希表.两个数组的交集;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num : nums2){
            set2.add(num);
        }

        return getIntersectionPart(set1, set2);
    }
    public int[] getIntersectionPart(Set<Integer> set1, Set<Integer> set2){
        if(set2.size() > set1.size()){
            return getIntersectionPart(set2, set1);
        }
        Set<Integer> interSection = new HashSet<>();
        for(int num : set1){
            if(set2.contains(num)){
                interSection.add(num);
            }
        }
        int[] intersectionPart = new int[interSection.size()];
        int index = 0;
        for(int num: interSection){
            intersectionPart[index++] = num;
        }
        return intersectionPart;
    }

    //因为最后得到的数组中的元素一定是递增的，所以可以对两个数组排序
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index = 0; //控制结果数组的指针位置
        int index1 = 0;
        int index2 = 0;
        int[] intersectPart = new int[nums1.length+nums2.length];
        while(index1 < nums1.length && index2 < nums2.length){
            int num1 = nums1[index1];
            int num2 = nums2[index2];
            if(num1 == num2){
                if(index == 0 || num1 != intersectPart[index-1]){ //保证加入数组的唯一性
                    intersectPart[index++] = num1;
                }
                index1++;
                index2++;
            }else {
                if(num1 < num2){
                    index1++;
                }else {
                    index2++;
                }
            }
        }
//        return intersectPart; //光是这样return有可能有的位置时0，多出来的空
        return Arrays.copyOfRange(intersectPart, 0, index);
    }
}

