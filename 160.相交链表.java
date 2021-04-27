/*
 * @Author: guo yawen
 * @Date: 2021-04-27 17:43:48
 * @LastEditTime: 2021-04-27 18:03:09
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\160.相交链表.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode first, second;
        first = headA;
        second = headB;
        while(first != second){
            if(first == null) first = headB;
            else first = first.next;
            if(second == null) second = headA;
            else second = second.next;
        }
        return first;
    }
}
// @lc code=end

