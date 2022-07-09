package 双指针.最小覆盖子串;

import java.util.Arrays;

//https://leetcode-cn.com/problems/minimum-window-substring/
public class Solution {
    //滑动窗口的右指针先包含T的所有字符
    //然后移动左指针，缩小窗口到在保证包含T的所有字符的前提下将距离减到最短
    public String minWindow(String s, String t) {
        int[] time = new int[128]; //用来存储字符出现次数
        boolean[] flag = new boolean[128]; //用来纪录t中存在的字符
        Arrays.fill(flag, false);
        for(int r = 0; r < t.length(); ++r){
            flag[t.charAt(r)] = true;
            ++time[t.charAt(r)];
        }
        int cnt = 0;
        int l = 0;
        int r = 0;
        int min_size = s.length()+1;
        int min_l = 0;
        for(; r < s.length(); ++r){
            if(flag[s.charAt(r)]){
                if(--time[s.charAt(r)] >= 0){
                    ++cnt;
                }
            }
            while(cnt == t.length()){
                if(r-l+1 < min_size) {
                    min_l = l;
                    min_size = r-l+1;
                }
                if(flag[s.charAt(l)] && ++time[s.charAt(l)] > 0){
                    --cnt;
                }
                ++l;
            }
        }
        return min_size > s.length() ?  "" : s.substring(min_l, min_l+min_size);

    }
}
