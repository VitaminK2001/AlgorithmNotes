package 贪心.根据身高重建队列;
//https://leetcode-cn.com/problems/queue-reconstruction-by-height/
import java.util.*;

public class Solution {
    Comparator<int[]> cmp = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2){
            //按照从矮到高的顺序排
            return o1[0] == o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
        }
    };
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, 0, people.length, cmp);
//        Vector<int[]> que = new Vector<>(people.length);
//        for(int i = 0; i < people.length; ++i){
//            int pos = people[i][1];
//            que.insertElementAt(people[i],pos);
//        }
//        return que;
        List<int[]> arrayList = new ArrayList<>();
        for(int i = 0; i < people.length; ++i){
            arrayList.add(people[i][1], people[i]);
        }
        return arrayList.toArray(new int[][]{});
    }
}
