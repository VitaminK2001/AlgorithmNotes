package 深度优先.两数之和输入BST;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class Solution {
    Set<Integer> hashset = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(hashset.contains(k-root.val)) return true;
        hashset.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}

class Solution2{
    Set<Integer> hashset = new HashSet<>();
    Queue<TreeNode> queue = new ArrayDeque<>();
    public boolean findTarget(TreeNode root, int k) {
        queue.offer(root);
        //这里不应该加root的值到set中
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(hashset.contains(k-node.val)) return true;
            hashset.add(node.val);
            if(node.left != null) queue.offer(node.left);
            if(node.right != null) queue.offer(node.right);
        }
        return false;
    }
}
