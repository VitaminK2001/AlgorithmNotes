package Fibonacci;

public class 递归去重 {
    public static int recurse(int num){
        int[] arr = new int[num+1];
        return 去重递归(arr, num);
    }
    private static int 去重递归(int[] arr, int num){
        if(num == 0)
            return 0;
        if(num == 1)
            return 1;
        if(arr[num] != 0){
            return arr[num];
        }
        //如果已经计算出来num-2和num-3在下面的计算式中不会再计算，解决重复计算的问题
        //时间 空间 复杂度都变成O(n)
        arr[num] = 去重递归(arr,num-1)+ 去重递归(arr,num-2);
        return arr[num];
    }

    public static void main(String[] args) {
        System.out.println(recurse(9));
    }


}
