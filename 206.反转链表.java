/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode r = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = r;
            r = head;
            head = tmp;
        }
        return r;
    }
}
