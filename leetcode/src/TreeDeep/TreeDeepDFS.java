package TreeDeep;
//求树的最小深度

public class TreeDeepDFS {

    static class TreenodeBFS {
        int val;
        TreenodeBFS left_node;
        TreenodeBFS right_node;
        TreenodeBFS(int val, TreenodeBFS left_node, TreenodeBFS right_node){
            this.val = val;
            this.left_node = left_node;
            this.right_node = right_node;
        }
    }


    public static int minDepth(TreenodeBFS tree){ //返回树的最小深度
        //两个递归终止条件
        if(tree == null){ //空节点
            return 0;
        }
        if(tree.left_node == null && tree.right_node == null){ //叶子结点
            return 1;
        }

        int min = Integer.MAX_VALUE; //因为是求最小值，先赋予最大值

        if(tree.left_node != null){
            min = Math.min(minDepth(tree.left_node), min); //min在每一层都被赋予初始MAX_VALUE值
        }

        if(tree.right_node != null){
            min = Math.min(minDepth(tree.right_node), min);
        }
        //在判断完每一层左右子树最小的深度以后
        return min+1; //因为是每一层的左右子树的最小深度，所以这一层的深度要＋1
    }

    public static void main(String[] args) {
        TreenodeBFS node4 = new TreenodeBFS(4, null, null);
        TreenodeBFS node5 = new TreenodeBFS(5, null, null);
        TreenodeBFS node2 = new TreenodeBFS(2, node4, node5);
        TreenodeBFS node6 = new TreenodeBFS(6, null, null);
        TreenodeBFS node3 = new TreenodeBFS(3, node6, null);
        TreenodeBFS node1 = new TreenodeBFS(1, node2, node3);

        System.out.println(minDepth(node1));
        iterator(0);
    }

    static int i = 0;
    public static void iterator(int a){
        System.out.println(a);
        if(a == 3)
            return;
        System.out.printf("这是第%d层", i++);
        iterator(i);
    }//每一层递归各是各的i
}
