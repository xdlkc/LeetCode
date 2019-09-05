/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            while(cur != null && tmp != null && cur.val == tmp.val) {
                tmp = tmp.next;
            }
            cur.next = tmp;
            cur = tmp;
        }
        return head;
    }
}

