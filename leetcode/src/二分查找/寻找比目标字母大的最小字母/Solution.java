package 二分查找.寻找比目标字母大的最小字母;
//https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/solution/xun-zhao-bi-mu-biao-zi-mu-da-de-zui-xiao-lhm7/
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if(target >= letters[n-1]) return letters[0];
        int left = 0;
        int high = n-1;
        while(left < high){
            int mid = (high-left)/2 + left;
            if(letters[mid]>target){ //最小上界
                high = mid;
            }else {
                left = mid+1; //缩小下界
            }
        }
        //当上下界重合
        return letters[high];
    }
}
