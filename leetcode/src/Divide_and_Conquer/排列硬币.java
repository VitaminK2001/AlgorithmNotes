package Divide_and_Conquer;

public class 排列硬币 {
    public static int coilation(int n){
        //排列的函数不会超过n行
        int low = 0;
        int high = n;
        if(n == 1){
            return 1;
        }
        //至少有两个硬币的时候
        //二分查找
        while(low + 1 < high){ //因为终止条件是low刚好比high小1
            int mid = low + (high-low)/2;
            if(n == (mid*(mid + 1))/2){
                return mid;
            }else if(n > (mid*(mid + 1))/2){
                low = mid+1;
            }else{
                high = mid-1;
            }//因为最终的结果一定是low，所以如果mid不行就把这个点去掉
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(coilation(1));
    }
}
