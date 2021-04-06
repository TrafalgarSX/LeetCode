/*
 * @Author: your name
 * @Date: 2021-04-01 22:25:00
 * @LastEditTime: 2021-04-02 15:03:06
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit 
 * @FilePath: \LeetCode\147.对链表进行插入排序.java
 */
/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return null;
        }
        //虚拟头节点，方便插入和找到有序列表的首结点
        ListNode vHead = new ListNode(Integer.MIN_VALUE,head);
        //有序列表的最后一个结点
        ListNode lastSorted = head;
        ListNode cur = head.next;
        //分为两种情况：
        //一种是 有序列表的最后一个结点小于要插入的结点，那样就可以不用插入，将最后有序结点改变即可。
        //一种是 需要插入，那先找到 有序列表中大于 要插入结点的值 的位置，那么就可以删除后面的插入结点，并将其插入之前找到的位置。
        while (cur != null) {
            if (cur.val > lastSorted.val) {
                lastSorted = cur;
                cur = lastSorted.next;
            } else {
                ListNode first = vHead;
                while(first.next.val < cur.val){
                    first = first.next;
                }
                //删除后面的cur结点
                ListNode temp = cur;
                cur = cur.next;
                lastSorted.next = cur;
                //将cur结点连接到前面来
                temp.next = first.next;
                first.next = temp;
            }
        }
        return vHead.next;
    }
}
// @lc code=end

