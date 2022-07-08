package List;

import java.util.HashSet;
import java.util.Set;



public class 判断环 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val, ListNode next){
            this.next = next;
            this.val = val;
        }
    }

    public static boolean hasCircle1(ListNode head){
        //利用set判断是否有环
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null){
            if(!set.add(head)){ //如果已经加过了
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCircle2(ListNode head){
        //利用快慢指针判断
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while(slow != quick){
            if(quick == null || quick.next == null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;

        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node2);
        node1.next = node5;
        System.out.println(hasCircle1(node1));
        System.out.println(hasCircle2(node1));
    }
}
