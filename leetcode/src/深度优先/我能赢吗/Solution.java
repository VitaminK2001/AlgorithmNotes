package 深度优先.我能赢吗;
import java.util.HashMap;
class Solution{
    HashMap<Integer, Boolean> memo = new HashMap<>();
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if((maxChoosableInteger+1) * maxChoosableInteger / 2 < desiredTotal) return false;
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }
    private boolean dfs(int maxChoosableInteger, int usedNumber, int desiredTotal, int currentTotal) {
        if(!memo.containsKey(usedNumber)){
            boolean res = false;
            for(int i = 0; i < maxChoosableInteger; ++i){
                if(((usedNumber>>i)&1) == 0){
                    if(currentTotal + i + 1 >= desiredTotal){
                        res = true;
                        break;
                    }
                    /**
                     * 如果当前选择的数字不能大于
                     * 则进入下一层dfs（对手的），如果对手的res为false，说明这一层自己的res 为 true
                     */
                    if(!dfs(maxChoosableInteger, usedNumber|(1<<i), desiredTotal, currentTotal+i+1)){
                        res = true;
                        break;
                    }
                }
            }
            memo.put(usedNumber, res);
        }
        return memo.get(usedNumber);
    }
}
