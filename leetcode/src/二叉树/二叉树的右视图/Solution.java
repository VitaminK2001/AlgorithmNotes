package 二叉树.二叉树的右视图;
//https://leetcode-cn.com/problems/binary-tree-right-side-view/
import java.util.*;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return null;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0; i < size; ++i){
                TreeNode node = que.poll();
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }
                if(i == size-1) list.add(node.val);
            }
        }
        return list;
    }
}
class Solution2{
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root){
        //if(root==null) return null; //不能在这里写，因为题目要求的是返回[]
        dfs(root, 0);
        return ans;
    }
    void dfs(TreeNode root, int depth){
        if(root==null) return ;
        if(ans.size()==depth){
            ans.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
    //保证第一次访问的结点永远是每一层最右边的结点，而且不会重复添加，因为一层加过一个后depth就++
    //dfs的返回值瑶void
}

