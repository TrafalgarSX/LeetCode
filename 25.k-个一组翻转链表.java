/*
 * @Author: guo yawen
 * @Date: 2021-04-09 16:26:20
 * @LastEditTime: 2021-04-09 17:45:13
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\25.k-个一组翻转链表.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
        ListNode temp ;
        while(curr != null){
            temp = curr.next;
            curr.next = pre;

            pre = curr;
            curr = temp;
        }
        return pre;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode vHead = new ListNode(-1,head);
        //tail用来找到 k 个结点的最后
        //first 是 k个结点的首结点，用来作为翻转 和 反转后的结尾
        ListNode pre = vHead, first = head, tail = vHead;
        //用来链接 断开的 k个 结点
        ListNode next;
        while (tail.next != null) {
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            //当tail为Null的时候，说明 链表长度不是 k的整数倍
            if(tail == null) break;
            //记忆下一个 k 个结点的首结点
            next = tail.next;

            tail.next = null;
            pre.next = reverse(first);
            //重新找到 虚拟头节点和头结点
            pre = first;
            tail = first;
            //将翻转后的链表重新链接上
            tail.next = next;

            first = next;
        }       
        return vHead.next;
    }
}
// @lc code=end

