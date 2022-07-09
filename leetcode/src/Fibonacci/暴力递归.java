package Fibonacci;

public class 暴力递归 {
    public static int Fibonacci(int num){
        //递归终止条件
        if(num == 0){
            return 0;
        }
        else if(num == 1){
            return 1;
        }//返回两个已知数
        else{
            return Fibonacci(num-1) + Fibonacci(num-2);
        }
    }
    //BF是O(n^2)
    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
    }

}
