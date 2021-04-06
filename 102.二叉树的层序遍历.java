/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        //当root为空时， 返回[]
        if(root == null){
            return list;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int times = count;           
            count = 0;
            ArrayList<Integer> arrayList = new ArrayList<>();
            //其实每一轮队列的大小就是 二叉树每一层结点的个数，不需要另外两个变量来保存
            for (int i = 0; i < times; i++) {
                TreeNode node = queue.poll();
                arrayList.add(node.val);
                if(node.left != null){
                    count++;
                    queue.add(node.left);
                }
                if(node.right != null){
                    count++;
                    queue.add(node.right);
                }
            }
            list.add(arrayList);
        }
        return list;

    }
}
// @lc code=end

