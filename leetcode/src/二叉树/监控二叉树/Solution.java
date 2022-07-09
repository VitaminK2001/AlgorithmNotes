package 二叉树.监控二叉树;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private int result = 0;
    public int traversal(TreeNode root){
        if(root == null) return 2;
        int left = traversal(root.left);
        int right = traversal(root.right);

        //如果左右结点有被覆盖
        if(left == 2 && right == 2) return 0; //无覆盖状态

        //如果左右节点中有一个没被覆盖
        if(left == 0 || right == 0) {
            result++;
            return 1; //有摄像头状态
        }

        //如果左右节点中有一个有摄像头还有一个是被覆盖
        if(left == 1 || right == 1) return 2; //被覆盖

        else return -1;
    }
    public int minCameraCover(TreeNode root) {
        if(traversal(root) == 0){
            result++;
        }
        return result;
    }
}
