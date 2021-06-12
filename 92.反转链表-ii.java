/*
 * @Author: guo yawen
 * @Date: 2021-06-11 11:28:15
 * @LastEditTime: 2021-06-11 13:34:26
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

    /**
     * * 把要反转的链表截出来，翻转后再接回去。
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

    }

    /**
     * *一次遍历的方法，很简单
     */
    public ListNode reverseBetweenOnce(ListNode head, int left, int right) {

        ListNode vHead = new ListNode(-1, head);
        ListNode pre, cur, next;
        pre = vHead;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        cur = pre.next;
        int count = right - left;
        for (int i = 0; i < count; i++) {
            next = cur.next;
            cur.next = cur.next.next;
            next.next = pre.next;
            pre.next = next;
        }
        /**
         * *为什么这样可以不考虑边界情况 [5] 1 1 这种情况
         */
        return vHead.next;
    }
}
// @lc code=end

