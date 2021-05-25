import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: guo yawen
 * @Date: 2021-05-25 00:03:56
 * @LastEditTime: 2021-05-25 20:45:00
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\101.对称二叉树.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
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
     * *递归方法， 用两个指针指向镜像的位置，进行比较。
     * @param left
     * @param right
     * @return
     */
    public boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
    public boolean checkIterative(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        TreeNode left, right;
        while(!queue.isEmpty()){
            left = queue.poll();
            right = queue.poll();
            if(left == null && right == null){
                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if(left.val == right.val){
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {

        // return check(root,root);
        return checkIterative(root);
    }

}
// @lc code=end

