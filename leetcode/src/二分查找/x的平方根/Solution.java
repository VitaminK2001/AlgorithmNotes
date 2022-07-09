package 二分查找.x的平方根;

public class Solution {
    public int mySqrt(int x) {
        double res = Math.sqrt(x);
        return (int)res;
    }
}
class Solution2{
    public int mySqrt(int x) {
        if(x == 0)return x;
        int l, r, mid, res;
        l = 0; r = x;
        while(l <= r){
            mid = l + (r-l)/2;
            res = x/mid;
            if(res == mid) return mid;
            else if(res < mid) r = mid-1;
            else l = mid+1;
        }
        return r;
    }
}
