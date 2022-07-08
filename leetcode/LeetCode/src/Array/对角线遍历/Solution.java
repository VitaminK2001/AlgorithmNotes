package Array.对角线遍历;

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int cnt = n*m;
        int[] ans = new int[cnt];
        int x = 0, y = 0, idx = 0, dir = 1;
        while(idx != cnt){
            ans[idx++] = mat[x][y];
            int nx = x, ny = y;
            if(dir == 1){
                nx = x-1; ny = y+1;
            }
            else{
                nx = x+1; ny = y-1;
            }
            if(idx < cnt && (nx < 0 || nx >= n || ny < 0 || ny >= m)){
                if(dir==1){
                    nx = y+1 < m ? x : x+1;
                    ny = y+1 < m ? y+1 : y;
                }else {
                    nx = x+1 < n ? x+1 : x;
                    ny = x+1 < n ? y : y+1;
                }
                dir*=-1;
            }
            x = nx; y = ny;
        }
        return ans;
    }
}
