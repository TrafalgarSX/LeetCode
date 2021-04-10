/*
 * @Author: guo yawen
 * @Date: 2021-04-10 08:28:52
 * @LastEditTime: 2021-04-10 08:41:11
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\24.两两交换链表中的节点.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        ListNode temp;
        while(curr != null){
            temp = curr.next;

            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
    public ListNode swapPairs(ListNode head) {
        if(head== null || head.next == null){
            return head;
        }
        ListNode vHead = new ListNode(-1,head);
        ListNode pre = vHead, tail = vHead, first = head;
        ListNode next;
        while (tail != null) {
            for (int i = 0; i < 2 && tail != null; i++) {
                tail = tail.next;
            }
            if(tail == null) break;
            next = tail.next;
            tail.next = null;

            pre.next = reverse(first);
            pre = first;
            tail = first;
            first = next;
            tail.next = first;
        }
        
        return vHead.next;
    }
}
// @lc code=end

