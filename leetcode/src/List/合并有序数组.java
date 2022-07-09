package List;

import java.util.Arrays;

public class 合并有序数组 {
    //采用apI的方式合并有序数组
    //https://blog.csdn.net/qq_39360985/article/details/79593418
    public static int[] Merge(int[] arr1, int m, int[] arr2, int n){
        //从下标为0的位置拷贝n个arr2中的数字到arr1中，从下标为m处开始
        System.arraycopy(arr2, 0, arr1, m, n);
        Arrays.sort(arr1);
        return arr1;
    }


    //采用双指针的方法合并有序数组
    //https://www.bilibili.com/video/BV1Jv411A7Ty?p=15
    public static int[] MergewithLink(int[] arr1, int m, int[] arr2, int n){
        //题目中说是最终返回arr1这个数组，但是我们需要一个额外的数组空间来存放arr1和arr2的合并
        //所以我们需要把arr1当做这个额外的数组空间，复制一份arr1_copy来和arr2合并最终存放在arr1中
        int[] arr1_copy = new int[m];
        System.arraycopy(arr1, 0, arr1_copy, 0, m);
        int p = 0;//指向arr1
        int p1 = 0;//指向arr1_copy
        int p2 = 0;//指向arr2

        while(p1 < m && p2 < n){
            arr1[p++] = arr1_copy[p1] > arr2[p2] ? arr2[p2++] : arr1_copy[p1++];
        }
        if(p1 < m){
            System.arraycopy(arr1_copy, p1, arr1, p1+p2, m+n-p1-p2);
        }
        if(p2 < n){
            System.arraycopy(arr2, p2, arr1, p1+p2, m+n-p1-p2);
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,10,11,0,0,0,0};
        int[] arr2 = {2,3,5,7};
//      Merge(arr1, 5, arr2, 4);
        MergewithLink(arr1, 5, arr2, 4);
        for(int elem : arr1){
            System.out.println(elem);
        }
    }
}
