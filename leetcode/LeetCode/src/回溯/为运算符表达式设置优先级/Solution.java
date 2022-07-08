package 回溯.为运算符表达式设置优先级;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < expression.length(); ++i){
            char c = expression.charAt(i);
            if(c == '-' || c == '+' || c == '*'){
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(Integer l : left){
                    for(Integer r : right){
                        switch (c){
                            case '+':
                                result.add(l+r);
                                break;
                            case '-':
                                result.add(l-r);
                                break;
                            case '*':
                                result.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if(result.size() == 0){
            result.add(Integer.valueOf(expression));
        }
        return result;
    }
}
