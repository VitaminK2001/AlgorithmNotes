package 滑动窗口.无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap(); //纪录字符对应的位置
        int left = 0;
        int max = 0; // 最大长度
        for(int i = 0; i < len; ++i){ //用i来控制右边下标
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i); //会更新原来字符的位置
            max = Math.max(max, i-left+1);
        }
        return max;
    }
}