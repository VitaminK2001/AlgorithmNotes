package 哈希表.罗马数字转整数;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans = 0;
        for(int i = 0; i < len; ++i){
            char c = s.charAt(i);
            if(i < len-1 && map.get(s.charAt(i+1)) > map.get(c)){
                ans -= map.get(c);
            }else {
                ans += map.get(c);
            }
        }
        return ans;
    }
}
