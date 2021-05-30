import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: guo yawen
 * @Date: 2021-05-30 17:13:44
 * @LastEditTime: 2021-05-30 19:10:14
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\111.二叉树的最小深度.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
     * *原始思路没弄清楚 深度的概念
     * *什么是深度： 从根节点到叶子节点的长度
     * *最小深度： 从根节点到叶子节点的最小长度
     * *广度优先搜索的解法
     */
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur;
        int ans = 0, count;
        while(!queue.isEmpty()){
            count = queue.size();
            ans++;
            for (int i = 0; i < count; i++) {
                cur = queue.poll();
                if(cur.left == null && cur.right == null){
                    return ans;
                }
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return ans;
    }
}
// @lc code=end

