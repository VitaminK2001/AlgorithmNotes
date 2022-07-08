package 图像平滑器;

class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] a = new int[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                int sum = 0;
                int cnt = 0;
                for(int x = i-1; x <= i+1; ++x){
                    for(int y = j-1; y <= j+1; ++y){
                        if(x >= 0 && x < m && y >= 0 && y < n){
                            sum += img[x][y];
                            cnt++;
                        }
                    }
                }
                if(cnt != 0) {
                    a[i][j] = sum / cnt;
                }
            }
        }
        return a;
    }
}