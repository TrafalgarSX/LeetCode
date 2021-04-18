/*
 * @Author: guo yawen
 * @Date: 2021-04-18 02:40:32
 * @LastEditTime: 2021-04-18 15:42:16
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\82.删除排序链表中的重复元素-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode vHead = new ListNode(-1, head);
        if(head == null){
            return head;
        }
        ListNode curr = vHead;
        while (curr.next != null && curr.next.next != null) {
            if( curr.next.val == curr.next.next.val){
                int x= curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            }else{
                curr = curr.next;
            }
        }
        return vHead.next;
    }
}
// @lc code=end

