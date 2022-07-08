package 数组.二倍数对数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap(); //存放arr中元素以及相应的个数
        for(int x : arr){
            cnt.put(x, cnt.getOrDefault(x,0)+1);
        }

        List<Integer> val = new ArrayList<>(); //存放有序的cnt中的值
        val.addAll(cnt.keySet());
        java.util.Collections.sort(val, (a,b)->Math.abs(a)-Math.abs(b));
        for(int x:val){
            if(cnt.getOrDefault(2*x, 0)<cnt.get(x)){
                return false;
            }
            //一次性全部抵消
            cnt.put(2*x, cnt.getOrDefault(2*x, 0)-cnt.get(x)); //这样最后到2*x的时候本来也就没有了
        }
        return true;
    }
}
