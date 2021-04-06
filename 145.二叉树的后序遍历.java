import java.util.*;

/*
 * @Author: guo yawen
 * @Date: 2021-04-01 22:50:54
 * @LastEditTime: 2021-04-05 01:02:32
 * @LastEditors: guo yawen
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\145.二叉树的后序遍历.java
 */
/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderNonTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return list;
    }

}
// @lc code=end

