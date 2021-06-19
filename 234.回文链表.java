/*
 * @author: guo yawen
 * @Date: 2021-06-19 19:51:43
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\234.回文链表.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    private ListNode endOfFirstHalf(ListNode head){
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;            
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode halfEnd = endOfFirstHalf(head);
        ListNode halfBegin = halfEnd.next;
        halfEnd.next = null;
        halfBegin = reverse(halfBegin);
        while(halfBegin != null){
            if(halfBegin.val != head.val){
                return false;
            }
            halfBegin = halfBegin.next;
            head = head.next;
        }
        return true;
    }
}
// @lc code=end

