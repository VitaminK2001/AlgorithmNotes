package Array;
import java.util.*;
//给定一个数组以及target值，要求返回数组中的两个元素，两个元素的和为target
public class 两数之和 { 
    public static int[] BF(int a[], int target){
        for(int i = 0; i < a.length; ++i){
            for(int j = i + 1; j < a.length; ++j){ //这样避免重复(不需要从1开始乘)
                if(a[i] + a[j] == target){
                    return new int[]{i, j}; //返回数组下标的写法,两个下标构成一个数组
                }
            }
        }
        return new int[0];
    }

    public static int[] solution(int a[], int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < a.length; ++i){
            if(map.containsKey(target - a[i])){
                return new int[]{map.get(target - a[i]), i};
            }
            map.put(a[i], i);
        }
        return new int[0];
    }

    //如果是在一个升序的数组中，可以用二分查找进一步缩短时间
    public static int[] if_sorted(int a[], int target){
        for(int i =0; i < a.length; ++i){
            int low = i, high = a.length - 1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(a[mid] == target - a[i]){
                    return new int[]{i, mid};
                }else if(a[mid] < target - a[i]){
                    low = mid + 1; //在之前的low~mid的区间内是没有的
                }else if(a[mid] > target - a[i]){
                    high = mid - 1; //在之前的mid~high区间内是没有的
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,8};
        System.out.println(Arrays.toString(BF(a, 9)));
        System.out.println(Arrays.toString(solution(a, 9)));
        System.out.println(Arrays.toString(if_sorted(new int[]{1,2,3,4,5,6,7,8,9}, 8)));
    }
}
