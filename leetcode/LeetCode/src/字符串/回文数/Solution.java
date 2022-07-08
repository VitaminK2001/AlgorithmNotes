package 字符串.回文数;

//https://leetcode-cn.com/problems/palindrome-number/solution/dong-hua-hui-wen-shu-de-san-chong-jie-fa-fa-jie-ch/
public class Solution {
    public boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

    public boolean isPalindrome2(int x){
        if(x < 0) return false;
        int div = 1;
        while(x / div >= 10) {
            div *= 10;
        }

        while(div > 0){
            int left = x / div;
            int right = x % 10;
            if(left != right) return false;
            x %= div;
            x /= 10;
            div /= 100;
        }
        return true;
    }

    //取出后半段数字进行翻转
    public boolean isPalindrome3(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while( x > revertedNumber){
            int number = x % 10;
            revertedNumber = revertedNumber*10 + number;
            x /= 10;
        }
        return revertedNumber == x || revertedNumber/10 == x;
    }
}
