import java.util.List;


/*
 * @Author: guo yawen
 * @Date: 2021-04-01 22:29:50
 * @LastEditTime: 2021-04-05 01:00:48
 * @LastEditors: guo yawen
 * @Description: In User Settings Edit;
 * @FilePath: \LeetCode\144.二叉树的前序遍历.java
 */
/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
// class TreeNode{
//     int val;
//     TreeNode left;
//     TreeNode right;
// }
import java.util.*;
class Solution {
    List<Integer> list =new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return list;
        }
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
    public List<Integer> preorderNonTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        TreeNode node = root;
        while(node != null || !stack.empty()){
            if(node!= null){
                list.add(node.val);
                stack.push(node);
                node = node.left; 
            }else{
                node = stack.pop();
                node = node.right;
            }
        }
        return list;
    }
}
// @lc code=end

