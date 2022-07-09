package 哈希表.相交链表;

import java.util.HashSet;
import java.util.Set;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = headA;
        Set<ListNode> set = new HashSet<>();
        while(node != null){
            set.add(node);
            node = node.next;
        }
        ListNode cur = headB;
        while(cur != null){
            if(set.contains(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    //也可以不用Hash表将空间复杂度降到1
    //用双指针
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
