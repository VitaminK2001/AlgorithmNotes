package 字符串.最长特殊子序列;

class Solution {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        for(int i = 0; i < strs.length; ++i){
            boolean check = false;
            for(int j = 0; j < strs.length; ++j){
                if(isSub(strs[i], strs[j])){
                    check = true;
                }
            }
            if(check){
                ans = Math.max(strs[i].length(), ans);
            }
        }
        return ans;
    }
    public boolean isSub(String t, String k){
        int posT = 0, posK = 0;
        while(posT < t.length() && posK < k.length()){
            if(t.charAt(posT) == k.charAt(posK)){
                posT++;
            }
            posK++;
        }
        return posT == t.length();
    }
}
