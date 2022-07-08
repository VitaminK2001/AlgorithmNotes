package 哈希表.字母异位词分组;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>()); //不需要创建对象
            list.add(str);
            map.put(key, list); //修改原来的key对应的value
        }
        return new ArrayList<List<String>>(map.values());
    }
}
