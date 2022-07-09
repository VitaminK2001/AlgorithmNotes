package 快速幂乘;

public class Solution {
//    public double myPow(double x, int n){ //计算x的n次方
//        if(n%2==0){
//           return myPow(x,n/2)*myPow(x, n/2);
//        }else{
//            return myPow(x, n/2)*myPow(x,n/2)*x;
//        }
//    }
    public double myPow(double x, int n){
        if(n == 1) return x;
        else{
            double half = myPow(x, n/2);
            if(n%2!=0){
                return half * half * x;
            }else{
                return half * half;
            }
        }
    }
    double powHelper(double x, int n){
        if(n == 0 || x == 1){
            return 1;
        }
        if(n < 0) return 1/powHelper(x, Math.abs(n));
        return myPow(x, n);
    }
}
