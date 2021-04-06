/*
 * @Author: guo yawen
 * @Date: 2021-04-05 12:00:28
 * @LastEditTime: 2021-04-05 13:33:30
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\21.合并两个有序链表.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode vHead = new ListNode(-1,l1);
        ListNode pre = vHead;
        while(pre.next != null && l2 != null){
            if (pre.next.val > l2.val) {
                 ListNode temp = l2;
                 l2 = l2.next;               
                 
                 temp.next = pre.next;
                 pre.next = temp;
            }
            pre = pre.next;
        }
        if(pre.next == null){
            pre.next = l2;
        }
        return vHead.next;
    }

    public ListNode mergeTwoListsOfficial(ListNode l1, ListNode l2) {
        ListNode vHead = new ListNode(-1);
        ListNode pre = vHead;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;   
        }
        pre.next = l1 == null ? l2 : l1;
        return vHead.next;
    }
}
// @lc code=end

