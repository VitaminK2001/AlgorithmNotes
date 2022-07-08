package 双指针.验证回文字符串;

import java.util.Arrays;

//https://leetcode-cn.com/problems/valid-palindrome-ii/
public class Solution {
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length()-1;
        int cnt = 0;
        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                ++cnt;
                if(cnt > 1){
                    return false;
                }
                else{
                    return validPalindrome(s, low+1, high) ||
                            validPalindrome(s, low, high-1);
                }
            }else{
                ++low;
                --high;
            }
        }
        return true;
    }
    public boolean validPalindrome(String s, int low, int high){
        for(int i = low, j = high; i < j; ++i, --j){
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }


}
