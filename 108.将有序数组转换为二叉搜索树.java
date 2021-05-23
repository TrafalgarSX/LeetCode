/*
 * @Author: guo yawen
 * @Date: 2021-05-23 15:05:20
 * @LastEditTime: 2021-05-23 15:20:56
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\108.将有序数组转换为二叉搜索树.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode recursive(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursive(nums, left, mid - 1);
        root.right = recursive(nums, mid + 1, right);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursive(nums, 0, nums.length - 1);
    }
}
// @lc code=end

