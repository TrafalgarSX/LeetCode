import java.util.PriorityQueue;

/*
 * @Author: guo yawen
 * @Date: 2021-04-07 21:16:04
 * @LastEditTime: 2021-04-07 22:14:38
 * @LastEditors: guo yawen
 * @Description: merge k list
 * @FilePath: \LeetCode\23.合并k个升序链表.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode merge(ListNode first, ListNode second){
        ListNode vHead = new ListNode(-1,first);
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
    //分治合并，自顶向下
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return mergeKLists(lists, 0, lists.length);
    }
    public ListNode mergeKLists(ListNode[] lists, int left, int right){
        if(left + 1 == right){
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode first = mergeKLists(lists, left, mid);
        ListNode second = mergeKLists(lists, mid, right);

        return merge(first, second);
    }
    
    //优先队列方法
    public ListNode mergeKListPriority(ListNode[] lists){
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
            (x,y)->x.val-y.val
        );
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        ListNode vHead = new ListNode(-1);
        ListNode tail = vHead;
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next != null){
                queue.offer(tail.next);
            }
        }
        return vHead.next;
    }
}
// @lc code=end

