/*
 * @Author: your name
 * @Date: 2021-03-31 15:55:08
 * @LastEditTime: 2021-03-31 16:10:58
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\19.删除链表的倒数第-n-个结点.java
 */
/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
//  class ListNode {
//       int val;
//       ListNode next;
//       ListNode() {}
//       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//   }

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vHead = new ListNode(-1);      
        vHead.next = head;
        ListNode tail = head;
        //找到倒数第 n + 1个结点
        while (n > 0) {
            tail = tail.next;
            n--;
        }
        //考虑到如果 是删除倒数第 length(list) 个的 结点
        //比如 list [1]  删除倒数 第一个 的情况。
        if (tail == null) {
            vHead.next = vHead.next.next;
            return vHead.next;
        }
        while (tail.next != null) {
           head = head.next;
           tail = tail.next; 
        }
        ListNode temp = head.next;
        head.next = temp.next;
        return vHead.next;
    }
}
// @lc code=end

