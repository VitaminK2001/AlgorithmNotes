package 滑动窗口.考试的最大困扰度;

public class Solution {
    String s;
    int k;
    public int maxConsecutiveAnswers(String answerKey, int _k) {
        s = answerKey;
        k = _k;
        return Math.max(getAns(s,k,'T'), getAns(s,k,'F'));
    }
    public int getAns(String s, int k, char c){
        int cnt = 0;
        int ans = 0;
        for(int left = 0, right = 0; right < s.length(); ++right){
            if(s.charAt(right) == c) cnt++;
            while(cnt > k){ //缩减左窗口只要少一个就继续往后推
                if(s.charAt(left++) == c) cnt--;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }

}
