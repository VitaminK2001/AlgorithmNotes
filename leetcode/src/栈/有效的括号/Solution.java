package 栈.有效的括号;

import java.util.*;

public class Solution {
    public boolean isValid(String s){
        int n = s.length();
        if( n % 2  != 0) return false;
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        Deque<Character> stack = new LinkedList<Character>();
        for(int i = 0; i < n; ++i){
            char ch = s.charAt(i);
            if(pairs.containsKey(ch)){
                if(stack.isEmpty() || stack.peek() != pairs.get(ch)){
                    return false;
                }
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
