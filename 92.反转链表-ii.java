/*
 * @Author: guo yawen
 * @Date: 2021-06-11 11:28:15
 * @LastEditTime: 2021-06-11 13:17:15
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\92.反转链表-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode vHead = new ListNode(-1, head);
        ListNode temp, pre, cur, ppre = null;
        pre = head;
        for (int i = 1; i < left; i++) {
            ppre = pre;
            pre = pre.next;
        }
        ListNode fin = pre;
        cur = pre.next;
        int count = right - left;
        for (int i = 0; i < count; i++) {
            temp = cur.next;
            cur.next = pre;
            
            pre = cur;
            cur = temp;
        }
        ppre.next = pre;
        fin.next = cur;
        
        return vHead.next;
    }
}
// @lc code=end

