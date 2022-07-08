package 回溯.根据二叉树创建字符串;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/construct-string-from-binary-tree/solution/gen-ju-er-cha-shu-chuang-jian-zi-fu-chua-e1af/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
};
public class Solution {
    public String tree2str(TreeNode root){
        if(root == null){
            return "";
        }
        if(root.left == null && root.right == null){
            return Integer.toString(root.val);
        }
        if(root.right == null){
            return new StringBuffer().append(root.val).append("(").
                    append(tree2str(root.left)).append(")").toString();
        }
        return new StringBuffer().append(root.val).append("(").
                append(tree2str(root.left)).append(")(").
                append(tree2str(root.right)).append(")").toString();
    }
}

class Solution2{
    public String tree2str(TreeNode root){
        //存储是否访问过的set
        Set<TreeNode> visited = new HashSet<>();
        //存储字符Buffer的结果
        StringBuffer ans = new StringBuffer();
        //堆栈控制放入的顺序
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root != null) {
            stack.offer(root);
        } //加入堆栈不代表已经visited
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
//            if(node != root){
//                visited.add(node);
//            }//这三行代码可以用下面一行的代替
            if(!visited.add(node)){ //如果这个结点之前访问过，说明是回来了，如果没有访问过visited加入这个结点
                if(node != root){
                    ans.append(")");
                }
                stack.pop();
            }
            else{
                if(node != root){
                    ans.append("(");
                } //应该在结点开始的时候加入(
                ans.append(node.val);
                if(node.left == null && node.right != null){
                    ans.append("()"); //相当于把左子树提前结束，将结果放入ans
                }
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
        return ans.toString();
    }
}














class Main{
    public static void main(String[] args) {
        StringBuffer s = new StringBuffer();
    }
}
