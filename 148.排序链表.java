/*
 * @Author: guo yawen
 * @Date: 2021-04-01 16:20:38
 * @LastEditTime: 2021-04-06 12:08:35
 * @LastEditors: guo yawen
 * @Description: In User Settings Editr,
 * @FilePath: \LeetCode\148.排序链表.java
 */
/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
import java.util.*;

class Solution {
    //自顶向下
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }
    public ListNode sortList(ListNode head,ListNode tail){
        // 不包含结点
        if(head == null){
            return head;
        }
        //only have one node 把每个结点解开链接，方便merge
        if(head.next == tail){
            head.next = null;
            return head;
        }
        //find mid node first;
        ListNode fast = head , slow = head;
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;

        ListNode sortedHead = sortList(head,mid);
        ListNode sortedTail = sortList(mid,tail);
        
        return merge(sortedHead,sortedTail);
    }
    public ListNode merge(ListNode first ,ListNode second){
        ListNode vHead = new ListNode(-1);
        ListNode pre = vHead;
        while(first != null && second != null){
            if(first.val < second.val){
                pre.next = first;
                first = first.next;
            }else{
                pre.next = second;
                second = second.next;
            }
            pre = pre.next;
        }
        pre.next = first == null ? second : first;
        return vHead.next;
    }
    //自底向上   编码问题，边界情况搞不清，暂时放弃弄懂
    public ListNode sortListBotToTop(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode countNode = head;
        while (countNode != null) {
            length++;
            countNode = countNode.next;
        }
        ListNode vHead = new ListNode(-1);
        vHead.next = head;
        for(int subLength =1 ; subLength < length ; subLength <<=1){
            ListNode pre = vHead;
            ListNode curr = vHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                //curr.next != null 
                for (int i = 1; i < subLength && curr != null && curr.next !=null; i++) {
                    curr = curr.next;    
                }
                
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode sorted = merge(head1, head2);
                pre.next = sorted;
                while (pre.next != null) {
                    pre =pre.next;
                }
                curr = next;
            }
        }

        return vHead.next;
    }
}
// @lc code=end

