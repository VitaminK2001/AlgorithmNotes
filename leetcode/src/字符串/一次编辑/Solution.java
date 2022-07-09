package 字符串.一次编辑;

public class Solution {
    public boolean oneEditAway(String first, String second) {
        int n = first.length();
        int m = second.length();
        if(Math.abs(n-m) > 1) return false;
        if(n < m){
            return oneEdit(first, second);
        }else if(n > m){
            return oneEdit(second, first);
        }else { //n=m不能单纯跳过要看每一个
            int i = 0, j = 0, cnt = 0;
            while(i < n && j < m){
                if(first.charAt(i) != second.charAt(j)){
                    cnt++;
                }
                ++i;
                ++j;
            }
            return cnt <= 1;
        }
    }
    public boolean oneEdit(String shortstr, String longstr){
        int len1 = shortstr.length();
        int len2 = longstr.length();
        int i = 0, j = 0;
        int cnt = 0;
        while(i < len1 && j < len2){
            if(shortstr.charAt(i) == longstr.charAt(j)){
                ++i;
                ++j;
            }else {
                ++cnt;
                ++j;
            }
        }
        return cnt <= 1;
    }
}
