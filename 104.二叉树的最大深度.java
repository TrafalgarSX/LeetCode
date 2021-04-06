/*
 * @Author: guo yawen
 * @Date: 2021-04-06 15:23:12
 * @LastEditTime: 2021-04-06 15:26:00
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\104.二叉树的最大深度.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
// @lc code=end

