/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode(0);
        ListNode temp = root;
        boolean flag = false;
        while (l1 != null && l2 != null) {

            int sum = l1.val + l2.val;
            if (flag) {
                sum += 1;
                flag = false;
            }
            if (sum > 9) {
                flag = true;
                sum %= 10;
            }
            temp.val = sum;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 == null && l2 == null) {
                break;
            }
            temp.next = new ListNode(0);
            temp = temp.next;
        }
        ListNode l = l1 == null ? l2 : l1;
        while (l != null) {

            int sum = l.val;
            if (flag) {
                sum += 1;
                flag = false;
            }
            if (sum > 9) {
                sum %= 10;
                flag = true;
            }
            temp.val = sum;
            l = l.next;
            if (l == null) {
                break;
            }
            temp.next = new ListNode(0);
            temp = temp.next;
        }
        if (flag) {
            temp.next = new ListNode(0);
            temp = temp.next;
            temp.val = 1;
        }
        return root;
    }
}
