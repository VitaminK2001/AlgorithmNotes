package CCFCSP.非零段划分;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] A = new int[n+1];
        int[] B = new int[n+2];
        B[0] = 0;
        B[n+1] = 0;
        for(int i = 1; i <= n; ++i){
            A[i] = sc.nextInt();
            B[i] = A[i];
        }
        Arrays.sort(A);
        int ans = 0;
        int sum = 0;
        for(int k = 1; k <= n; ++k){
            if(B[k-1]==0&&B[k]>0) sum++;
        }
        ans = Math.max(ans, sum);
        for(int i = 1; i <= n; ++i){
            int p = A[i];
            for(int j = 1; j <= n; ++j){
                if(B[j]<=p){
                    if(B[j]!=0){
                        B[j] = 0;
                        if(B[j-1]>0 && B[j+1]>0) sum++;
                        if(B[j-1]==0 && B[j+1]==0) sum--;
                    }
                }
            }
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
        Set<Integer> a = new HashSet<>();
        Iterator it = a.iterator();
    }
}
