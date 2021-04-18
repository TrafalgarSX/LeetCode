/*
 * @Author: guo yawen
 * @Date: 2021-04-18 02:23:30
 * @LastEditTime: 2021-04-18 02:39:18
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\83.删除排序链表中的重复元素.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicatesMy(ListNode head) {
        ListNode vHead = new ListNode(-1, head);
        if(head == null) return head;
        ListNode slow = head, fast = head.next;
        while(fast != null){
            if(slow.val == fast.val){
                fast = fast.next;
                slow.next = fast;
            }else{
                slow = fast;
                fast = fast.next;
            }
        }
        return vHead.next;
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) return head;
        ListNode curr = head;
        while(curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }
}
// @lc code=end

