package N叉树的层序遍历;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        while(!que.isEmpty()){
            path.clear();
            int size = que.size();
            for(int i = 0; i < size; ++i){
                Node cur = que.poll();
                path.add(cur.val);
                for(int j = 0; j < cur.children.size(); ++j){
                    que.offer(cur.children.get(j));
                }
            }
            res.add(new ArrayList<>(path));
        }
        return res;
    }
}
