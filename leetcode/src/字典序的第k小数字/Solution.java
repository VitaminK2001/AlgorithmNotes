package 字典序的第k小数字;

public class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while(k > 0) { //只要k为0 cur就到达指定的地点
            int num = layerNum(cur, n);
            if (num > k) {
                k--;//控制k别减成负数了
                cur *= 10; //控制cur别加大了
            }
            else {
                k -= num;
                cur++; //直接跳过顶点下面的所有层，因为知道层数不够

            }
        }
        return cur;
    }
    public int layerNum(int cur, long n){
        int num = 0;
        long first = cur;
        long last = cur;
        while(first <= n){
            num += Math.min(last,n) - first + 1;
            first *= 10;
            last = last * 10 + 9; //注意这里不能写成last *= 10 + 9;
        }
        return num;
    }
}
