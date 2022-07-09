package TreeDeep;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int getDepth(TreeNode node){
        if(node == null) return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        int depth = 1+Math.max(left, right);
        return depth;
    }
    public int maxDepth(TreeNode root){
        return getDepth(root);
    }
}

class Solution2{
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        LinkedList<TreeNode> que = new LinkedList<>();
        que.push(root);
        int depth = 0;
        while(!que.isEmpty()){
            int size = que.size();
            depth++;
            for(int i = 0; i < size; ++i){
                TreeNode node = que.poll();
                if(node.left!=null) que.offer(node.left);
                if(node.right!=null) que.offer(node.right);
            }
        }
        return depth;
    }
}

class Solution3{

}
