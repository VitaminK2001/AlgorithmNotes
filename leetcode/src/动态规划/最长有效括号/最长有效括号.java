package 动态规划.最长有效括号;

public class 最长有效括号 {
    public int Solution(String s){
        char ch[] = s.toCharArray();
        int len = s.length();
        int[] dp = new int[len];
        for(int i = 0; i < len; ++i){
            if(ch[i] == '(') dp[i] = 0;
            if(ch[i] == ')'){
                if(i-1 >= 0 && ch[i-1] == '('){
                    if(i >= 2) dp[i] = dp[i-2]+2;
                    else dp[i] = 2;
                }
                else if(i-1>=0 && ch[i-1] == ')'){
                    if(i-1-dp[i-1]>=0 && ch[i-1-dp[i-1]] == '(') dp[i] = i-2-dp[i-1]>0 ? dp[i-1]+dp[i-2-dp[i-1]]+2 : dp[i-1] + 2;
                    else dp[i] = 0;
                }
            }
        }
        return 0;
    }
}
