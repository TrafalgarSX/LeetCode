/*
 * @Author: guo yawen
 * @Date: 2021-05-21 20:58:45
 * @LastEditTime: 2021-05-21 21:12:57
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\237.删除链表中的节点.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
    //    ListNode next = node.next;
       node.val = node.next.val;
       node.next = node.next.next;
    }
}
// @lc code=end

