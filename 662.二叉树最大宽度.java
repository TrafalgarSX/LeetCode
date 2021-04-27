import java.util.Deque;
import java.util.LinkedList;


/*
 * @Author: guo yawen
 * @Date: 2021-04-14 17:28:38
 * @LastEditTime: 2021-04-25 23:43:01
 * @LastEditors: guo yawen
 * @Description: 0;
 * @FilePath: \LeetCode\662.二叉树最大宽度.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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
    class AnnotatedNode {
        TreeNode node;
        int pos;
        public AnnotatedNode(TreeNode node, int pos){
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        Deque<AnnotatedNode> queue = new LinkedList<>();
        queue.offer(new AnnotatedNode(root, 0));
        int ans = 0, left = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            //! 用来标记最左侧的结点是否访问过。
            boolean leftFlag = true;
            //*同一层最左侧的下标和最右侧的下标进行比较。
            for (int i = 0; i < len; i++) {
                AnnotatedNode temp = queue.poll();
                if( temp.node != null){
                    if(leftFlag){
                        left = temp.pos;
                        leftFlag = false;
                    }
                    queue.offer(new AnnotatedNode(temp.node.left, temp.pos * 2));
                    queue.offer(new AnnotatedNode(temp.node.right, temp.pos * 2 + 1));
                    //!因为判断不了某一层最后一个结点在哪里，所以每次都计算一次。
                    ans = Math.max(ans, temp.pos - left + 1);
                }
            }
        }
        return ans;
    }
}
// @lc code=end

