package 字符串.文件的最长绝对路径;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthLongestPath(String input) {
        //每一行文件的深度通过\t来体现，\n没用
        //需要纪录每一行文件名字的长度
        //如果有.说明这一行的文件是真的文件，这个时候len起到比较的作用
        //用栈保存遍历的路径，栈中元素的个数是路径的深度，栈顶元素是当前路径的长度
        int n = input.length();
        int pos = 0;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while(pos < n){
            int depth = 1; //文件所在层的深度
            while(pos < n && input.charAt(pos) == '\t'){
                pos++;
                depth++;
            }
            boolean isFile = false;
            int len = 0;
            while(pos < n && input.charAt(pos) != '\n'){
                if(input.charAt(pos) == '.'){
                    isFile = true;
                }
                pos++;
                len++;
            }
            pos++;
            while(stack.size() >= depth){
                stack.pop();
            }
            if(!stack.isEmpty()){
                len += stack.peek()+1;
            }
            if(isFile){
                ans = Math.max(len, ans);
            }else {
                stack.push(len);
            }
        }
        return ans;
    }
}

class Solution2{
    public int lengthLongestPath(String s) {
        Map<Integer, String> map = new HashMap<>();
        int n = s.length();
        String ans = null;
        for(int i = 0; i< n; ){
            //i表示层数
            int level = 0;
            while(i < n && s.charAt(i) == '\t' && ++level >= 0) ++i;
            int j = i;
            boolean isDir = true;
            while(j < n && s.charAt(j) != '\n') {
                if (s.charAt(j++) == '.') {
                    isDir = false;
                }
            }
                String cur = s.substring(i, j);
                String prev = map.getOrDefault(level-1, null);
                String path = prev == null ? cur : prev + "/" + cur;
                if(isDir) map.put(level, path);
                else if(ans == null || path.length() > ans.length()) ans = path;
                i = j+1; //该层路径判断完毕，进入下一层
            }
        return ans == null ? 0 : ans.length();
    }
}