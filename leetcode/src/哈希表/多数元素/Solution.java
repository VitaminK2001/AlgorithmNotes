package 哈希表.多数元素;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Map<Integer,Integer> countNums(int[] nums){
        Map<Integer, Integer> count = new HashMap<>(nums.length);
//        for(int num : nums){
//            count.put(num, count.get(num)+1); //这里不能直接get会出现空指针异常
//        }
        for(int num: nums){
            if(!count.containsKey(num)){
                count.put(num, 1);
            }else {
                count.put(num, count.get(num)+1);
            }
        }
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Map.Entry<Integer, Integer> res = null;
        Map<Integer, Integer> count = countNums(nums);
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            if(res == null || entry.getValue() > res.getValue()){
                res = entry;
            }
        }
        return res.getKey();
    }
}
