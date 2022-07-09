package Divide_and_Conquer;
import java.util.*;

public class BinarySearch{

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,6,6,6,13,18};
        System.out.println(lowerBound(nums, 6));
    }

    public static int lowerBound(int[] nums, int target){ //找小于target的最后一个元素
        if(nums == null || nums.length == 0) //终止条件是数组为空或者是数组中没有元素
            return -1;
        int lb = -1, ub = nums.length;
        while(lb + 1 < ub){
            int mid = lb + (ub - lb) / 2; //有效防止两数相加后溢出
            if(nums[mid] < target){
                lb = mid; //保证lb处的值一定是小于target的
            } else {
                ub = mid; //保证ub处的值一定是大于等于target的
            }   
        }//最终结束的条件只能是lb+1=ub所以lb处是小于target值的最后一个元素
        return lb+1;
    }

    public static int upperBound(int[] nums, int target){ //找大于target的第一个元素
        if(nums == null || nums.length == 0){
            return -1;
        }
        int lb = -1, ub = nums.length;
        while(lb + 1 < ub){
            int mid = lb + (ub-lb)/2;
            if(nums[mid] > target){
                ub = mid; //保证ub处的值一定是大于target的

            }else{
                lb = mid; //保证lb处的值一定是小于等于target的
            }
        }//最终结束的条件只能是lb+1=ub所以ub处是大于target值的第一个元素
        return ub - 1;
    }
}


