
/*
 * @Author: guo yawen
 * @Date: 2021-04-05 00:56:52
 * @LastEditTime: 2021-04-05 01:01:33
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\CodeUtil.java
 * TrafalgarSX
 */
public class CodeUtil {
    
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }