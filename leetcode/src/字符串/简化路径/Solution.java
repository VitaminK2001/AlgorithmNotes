package 字符串.简化路径;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String name:names){
            if("..".equals(name)){
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            }else if(!".".equals(name) && name.length() > 0){ //防止存在空串
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if(stack.isEmpty()){
            ans.append('/');
        }else{
            while(!stack.isEmpty()){
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }


}
