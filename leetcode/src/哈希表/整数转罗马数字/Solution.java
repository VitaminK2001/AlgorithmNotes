package 哈希表.整数转罗马数字;

public class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
        StringBuffer ans = new StringBuffer();
        for(int i = 0; i < 13; ++i){
            int value = values[i];
            while(num >= value){
                num -= values[i];
                ans.append(symbols[i]);
            }
            if(num == 0) break;
        }
        return ans.toString();
    }
}
