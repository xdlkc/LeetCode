/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> q = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !q.isEmpty()) {
            while (cur != null) {
                q.push(cur);
                cur = cur.left;
            }
            cur = q.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}

