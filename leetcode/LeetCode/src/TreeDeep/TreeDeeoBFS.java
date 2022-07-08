package TreeDeep;
//求树的最小深度
import java.util.LinkedList;
import java.util.Queue;

public class TreeDeeoBFS{

    static class TreenodeBFS{
        int val;
        int deep;
        TreenodeBFS left_node;
        TreenodeBFS right_node;
        TreenodeBFS(int val, TreenodeBFS left_node, TreenodeBFS right_node){
            this.val = val;
            this.left_node = left_node;
            this.right_node = right_node;
        }
    }

    public static int BFS(TreenodeBFS root){
        if(root == null){
            return 0;
        }
        //Queue是泛型用链表实现先入先出
        Queue<TreenodeBFS> queue = new LinkedList<TreenodeBFS>();

        root.deep = 1;
        queue.offer(root);

        while(!queue.isEmpty()){

            TreenodeBFS node = queue.poll();

            if(node.left_node == null && node.right_node == null){
                return node.deep;
            }
            if(node.left_node != null){
                node.left_node.deep = node.deep + 1;
                queue.offer(node.left_node);
            }
            if(node.right_node != null){
                node.right_node.deep = node.deep + 1;
                queue.offer(node.right_node);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreenodeBFS node4 = new TreenodeBFS(4, null, null);
        TreenodeBFS node5 = new TreenodeBFS(5, null, null);
        TreenodeBFS node2 = new TreenodeBFS(2, node4, node5);
        TreenodeBFS node6 = new TreenodeBFS(6, null, null);
        TreenodeBFS node3 = new TreenodeBFS(3, node6, null);
        TreenodeBFS node1 = new TreenodeBFS(1, node2, node3);

        System.out.println(BFS(node1));
    }
}
