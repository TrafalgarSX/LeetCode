/*
 * @Author: guo yawen
 * @Date: 2021-04-02 11:48:31
 * @LastEditTime: 2021-04-05 01:01:08
 * @LastEditors: guo yawen
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\94.二叉树的中序遍历.java
 */
/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode  node = root;
        while (node != null || !stack.empty()) {
           if (node != null) {
                stack.push(node);
                node = node.left;
           } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
           } 
        }
        return list;
    }
}
// @lc code=end

