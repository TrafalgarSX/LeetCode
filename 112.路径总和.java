/*
 * @Author: guo yawen
 * @Date: 2021-06-04 21:24:13
 * @LastEditTime: 2021-06-04 22:21:07
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\112.路径总和.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    /**
     * *递归解法，典型递归，但这种递归的范式也很典型
     * @param node
     * @param curSum
     * @param targetSum
     * @return
     */
    public boolean dfs(TreeNode node,int curSum, int targetSum){
        if(node == null){
            return false;
        }
        if(node.left == null && node.right == null){
            curSum += node.val;
            return curSum == targetSum;
        }
        curSum += node.val;
        return dfs(node.left, curSum, targetSum) || dfs(node.right, curSum, targetSum);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
}
// @lc code=end

