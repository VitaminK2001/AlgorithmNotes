package 字符串.旋转字符串;
//https://leetcode-cn.com/problems/rotate-string/
public class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        int m = goal.length();
        if(m != n) return false;

        for(int gap = 0; gap < n; ++gap){  //用来判断旋转产生差距是多少的，gap = 0就是gap = n
            boolean flag = true;
            for(int j = 0; j < n; ++j){  //用来遍历的
                if(s.charAt((gap+j)%n) != goal.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }

    public boolean rotateString2(String s, String goal){
        // 所有旋转得到字符串都是s+s的子字符串
        return s.length()==goal.length()&&(s+s).contains(goal);
    }
}
