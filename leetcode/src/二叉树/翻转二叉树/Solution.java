package 二叉树.翻转二叉树;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}

public class Solution {
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    //也可先交换，再递归
}
