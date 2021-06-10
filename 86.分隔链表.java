/*
 * @Author: guo yawen
 * @Date: 2021-06-10 12:18:02
 * @LastEditTime: 2021-06-10 13:30:57
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\86.分隔链表.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
     * *用一个比x值大于等于的链表，另一个用 < x 的链表
     * *最后合并两个链表
     * *记得将两个链表末尾置为正确的结果。
     * !链表考的是什么： 哨兵节点、 虚拟节点和链表指针的移动
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode bigger, smaller;
        bigger = new ListNode(-1);
        smaller = new ListNode(-1); 
        ListNode bNext, sNext;
        bNext = bigger;
        sNext = smaller;

        while(head != null){
            if(head.val < x){
                sNext.next = head;
                sNext = sNext.next;
            }else{
                bNext.next = head;
                bNext = bNext.next;
            }
            head = head.next;
        }

        sNext.next = bigger.next;
        bNext.next = null;
        return smaller.next;
    }
}
// @lc code=end

