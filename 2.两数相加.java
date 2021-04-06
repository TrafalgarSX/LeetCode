/*
 * @Author: guo yawen
 * @Date: 2021-03-30 00:44:28
 * @LastEditTime: 2021-04-05 00:58:55
 * @LastEditors: guo yawen
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\2.两数相加.java
 */
/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode vhead = new ListNode(-1);
        ListNode cur = vhead;
        int carry = 0;
        while(l1!=null && l2!= null){
            int sum = l1.val + l2.val + carry;
            carry = sum /10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            carry = sum /10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            carry = sum /10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return vhead.next;
    }
}
// @lc code=end

