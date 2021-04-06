/*
 * @Author: guo yawen
 * @Date: 2021-04-06 15:07:33
 * @LastEditTime: 2021-04-06 15:14:49
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\110.平衡二叉树.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public int avlHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = avlHeight(root.left);
        int right = avlHeight(root.right);
        if( left == -1 || right == -1 || Math.abs(left -right) > 1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        return avlHeight(root) == -1 ? false : true;
    }
}
// @lc code=end

