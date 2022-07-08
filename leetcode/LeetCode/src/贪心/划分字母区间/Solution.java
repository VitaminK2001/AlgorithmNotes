package 贪心.划分字母区间;
//https://leetcode-cn.com/problems/partition-labels/
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[27];
        for(int i = 0; i < s.length(); ++i){
            //每个字符所在的最远位置存储到hash数组中
            hash[s.charAt(i)-'a'] = i;
        }
        int right = 0;
        int left = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i  < s.length(); ++i){
            //包含字符最远位置
            right = Math.max(right, hash[s.charAt(i)-'a']);
            //如果当前位置就是最远位置
            if(i == right){
                //计算left到right的长度
                result.add(right-left+1);
                //更新left
                left = i+1;
            }
        }
        return result;
    }
}
//贪心贪在字符串的顺序是无法改变的，保证每个字符串的长度最小则划分的字符串个数越多
//而保证字符串的长度最小就是到达靠前面字符最终出现的位置就切割

