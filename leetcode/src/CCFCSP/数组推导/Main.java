package CCFCSP.数组推导;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] B = new int[n];
        for(int i = 0; i < n ; ++i){
            B[i] = sc.nextInt();
        }
        int maxSum = 0;
        int minSum = 0;
        for(int b : B){
            maxSum += b;
        }
        for(int i = 0; i < n; ){
            if(B[i] == 0) ++i;
            if(B[i] != 0){
                minSum += B[i];
                int j = 0;
                for(j = i+1; j < n; ++j){
                    if(B[i] < B[j]){
                        break;
                    }
                }
                if(j == n) break;
                i = j;
            }
        }
        System.out.println(maxSum);
        System.out.println(minSum);
    }
}
