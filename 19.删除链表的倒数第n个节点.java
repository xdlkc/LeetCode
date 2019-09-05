/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        // 防止链表只有1个结点
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode r1 = dum;
        ListNode r2 = dum;
        while (n > 0 && r2 != null) {
            r2 = r2.next;
            n--;
        }
        while (r2.next != null) {
            r2 = r2.next;
            r1 = r1.next;
        }
        r1.next = r1.next.next;

        return dum.next;
    }
}
