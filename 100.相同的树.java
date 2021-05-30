import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: guo yawen
 * @Date: 2021-05-29 21:42:49
 * @LastEditTime: 2021-05-29 21:49:35
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\100.相同的树.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
     * *广度优先搜索
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> pQueue = new LinkedList<>();
        pQueue.add(p);
        pQueue.add(q);
        TreeNode first, second;
        while(!pQueue.isEmpty()){
            first = pQueue.poll();
            second = pQueue.poll();
            if(first == null && second == null){
                continue;
            }
            if(first == null || second == null){
                return false;
            }
            if(first.val == second.val){
                pQueue.add(first.left);
                pQueue.add(second.left);
                pQueue.add(first.right);
                pQueue.add(second.right);
            }else{
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

