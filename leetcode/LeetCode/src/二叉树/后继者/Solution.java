package 二叉树.后继者;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    //中序遍历
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = root, prev = null;
        Deque<TreeNode> dq = new ArrayDeque<>();
        while(!dq.isEmpty() || curr != null){
            while(curr != null){
                dq.push(curr);
                curr = curr.left;
            }
            curr = dq.pop();
            if(prev == p){
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }
}
