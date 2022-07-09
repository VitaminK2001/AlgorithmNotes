package 二叉树.删除二叉搜索树中的结点;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else {
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            else { //左右子树都不为空
                TreeNode node = root.right;
                while(node.left != null){
                    node = node.left;
                }
                node.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
}
