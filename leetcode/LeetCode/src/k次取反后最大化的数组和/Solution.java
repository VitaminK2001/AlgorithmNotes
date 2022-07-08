package k次取反后最大化的数组和;

import java.util.*;

class cmp implements Comparator<Integer>{
    public int compare(Integer a, Integer b){ //复写的方法访问性只能变大
        if(Math.abs(a) > Math.abs(b)) return -1;
        if(Math.abs(a) < Math.abs(b)) return 1;
        else return 0;
    }
}

public class Solution {

    int largestSumAfterKNegations(int[] A, int K){
        ArrayList<Integer> L = new ArrayList<>(A.length);
        for(int i = 0; i < A.length; ++i){
            L.add(A[i]);
        }
        Collections.sort(L, (n1, n2) -> Math.abs(n2) - Math.abs(n1));
        for(int i = 0; i < L.size(); ++i){
            if(L.get(i).intValue() < 0 && K > 0){
                K--;
                L.set(i, -1*L.get(i));
            }
        }
        if(K % 2  == 1) L.set(L.size()-1, -1*L.get(L.size()-1));
        int result = 0;
        for(int a : L){
            result+=a;
        }
        return result;
    }
}

class Test{
    public static void main(String[] args) {
        int[] arr = new int[5];
        List<Integer> l = new ArrayList<>();
        l.add(5);l.add(4);l.add(3);l.add(2);l.add(1);
        l.sort(Comparator.comparingInt(n -> n)); /*和下面一句话相同*/
        l.sort((n1,n2)->n1-n2);
        Collections.sort(l, new cmp());
        Arrays.sort(arr);
    }
}
