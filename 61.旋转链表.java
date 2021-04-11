/*
 * @Author: guo yawen
 * @Date: 2021-04-10 23:57:49
 * @LastEditTime: 2021-04-11 11:56:38
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\61.旋转链表.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    //形成环
    public ListNode rotateRightLoop(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null){
            return head;
        }
        ListNode pre = new ListNode(-1,head);
        int len = 0;
        while (pre.next != null ) {
            len++;
            pre = pre.next;
        }
        int count = len - k % len;
        //k 为n 的整数倍
        if(count == len){
            return head;
        }
        //这句不能放到前面，否则上面会返回环。
        pre.next = head;
        for (int i = 0; i < count; i++) {
            pre = pre.next;
        }
        head = pre.next;
        pre.next = null;
        return head;

    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        ListNode temp;
        while (curr != null) {
            temp = curr.next;

            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
    //旋转链表方法
    public ListNode rotateRight(ListNode head, int k) {
        //list 的长度为 0 或 1 时 返回空或自己， 即都是自己
        if(head == null || head.next == null){
            return head;
        }
        ListNode vHead = new ListNode(-1,head);
        //旋转部分链表 四个必备变量 pre tail first next
        ListNode pre = vHead, tail = vHead, next;
        ListNode first = head;
        // k 有可能超过链表长度 
        //先得到链表长度，然后确定应该旋转多少
        int len = 0;
        while (first != null) {
            len++;
            first = first.next;
        }
        first = head;
        int count = len - k % len;
        for (int i = 0; i < count; i++) {
            tail = tail.next;
        }
        next = tail.next;
        tail.next = null;
        //旋转前 一 部分
        pre.next = reverse(first);
        pre = first;
        tail = first;
        tail.next = next;
        first = next;

        //旋转后一部分
        pre.next = reverse(first);
        //旋转所有结点
        vHead.next = reverse(vHead.next);
        // final result
        return vHead.next;
    }
}
// @lc code=end

