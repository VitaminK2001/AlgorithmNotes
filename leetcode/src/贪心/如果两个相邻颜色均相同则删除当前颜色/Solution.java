package 贪心.如果两个相邻颜色均相同则删除当前颜色;

public class Solution {
    public boolean winnerOfGame(String colors) {
        int cntA = 1;
        int cntB = 1;
        char[] col = colors.toCharArray();
        for(int i = 1; i < col.length; ++i){
            if(col[i] == 'A' && col[i-1] == 'A' && col[i+1] == 'A'){
                cntA++;
            }
            if(col[i] == 'B' && col[i-1] == 'B' && col[i+1] == 'B'){
                cntB++;
            }
        }
        return cntA > cntB;
    }
}
