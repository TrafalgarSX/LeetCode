/*
 * @Author: guo yawen
 * @Date: 2021-04-06 15:16:00
 * @LastEditTime: 2021-04-06 15:22:05
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\206.反转链表.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
// @lc code=end

