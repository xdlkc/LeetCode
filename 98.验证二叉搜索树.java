/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null) {
            if (root.val >= min) {
                return false;
            }
        }
        if (max != null) {
            if (root.val <= max) {
                return false;
            }
        }
        return isValidBST(root.left, root.val, max) && isValidBST(root.right, min, root.val);
    }

}

