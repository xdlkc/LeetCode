/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 *
 */

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode root = null;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            listNode = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            listNode = new ListNode(l2.val);
            l2 = l2.next;
        }
        root = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                listNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                listNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            listNode = listNode.next;
        }
        if (l1 != null) {
            listNode.next = l1;
        }
        if (l2 != null) {
            listNode.next = l2;
        }
        return root;
    }
}
