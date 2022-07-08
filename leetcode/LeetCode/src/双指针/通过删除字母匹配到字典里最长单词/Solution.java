package 双指针.通过删除字母匹配到字典里最长单词;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for(String t : dictionary){
            int i = 0; int j = 0;
            while(i < t.length() && j < s.length()){
                if(s.charAt(j) == t.charAt(i)){
                    ++i;
                }
                ++j;
            }
            if(i == t.length()){ //防止是s不够长
                if(t.length() > res.length() || t.length() == res.length() && t.compareTo(res) < 0){
                    res = t;
                }
            }
        }
        return res;
    }
}

class Solution2{
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>(){
            public int compare(String s1, String s2){
                if(s1.length() != s2.length()){
                    return s2.length()-s1.length();
                }
                else{
                    return s1.compareTo(s2);
                }
            }
        });
        for(String t : dictionary){
            int i = 0; int j = 0;
            while(i < t.length() && j < s.length()){
                if(s.charAt(j) == t.charAt(i)){
                    ++i;
                }
                ++j;
            }
            if(i == t.length()){
                return t;
            }
        }
        return "";
    }
}