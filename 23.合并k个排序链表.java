/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n <= 0) {
            return null;
        }
        int interval = 1;
        while (interval < n) {
            for (int i = 0; i < n - interval; i += 2 * interval) {
                lists[i] = mergeList(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }
    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode tmp = node;
        while (l1 != null && l2 != null) {
            tmp.next = new ListNode(0);
            tmp = tmp.next;
            if (l1.val < l2.val) {
                tmp.val = l1.val;
                l1 = l1.next;
            } else {
                tmp.val = l2.val;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return node.next;
    }
}

