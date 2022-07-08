package CCFCSP.序列查询;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N = sc.nextInt();
        int[] a = new int[n+1];
        int sum = 0;
        a[0] = 0;
        for(int i = 1; i <= n; ++i){
            a[i] = sc.nextInt();
        }
        for(int i = 1; i < n; ++i){
            sum += (a[i+1]-a[i])*i;
        }
        sum += (N - a[n])*n;
        System.out.println(sum);
    }
}
