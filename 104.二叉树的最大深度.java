/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    public int maxDepth(TreeNode root, int curDepth) {
        if (root == null) {
            return curDepth;
        }
        return Math.max(maxDepth(root.left, curDepth+1), maxDepth(root.right, curDepth+1)); 
    }

}

