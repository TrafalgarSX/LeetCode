import java.util.HashSet;

/*
 * @Author: guo yawen
 * @Date: 2021-04-09 23:20:01
 * @LastEditTime: 2021-04-12 23:40:52
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\142.环形链表-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
    // hash method
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }else{
                set.add(head);
                head = head.next;
            }
        }
        return null;
    }
    // double pointer
    /**
     * * Better Comments 试用。
     * ! 数学证明学会
     * ？ 为什么快慢指针相遇时，慢指针没有走完一圈环
     * ？ 快慢指针相遇的 长度问题。
     * TODO 完成这道题。
     * @param head
     * @return
     */
    public ListNode detectCycleNode(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                while(slow != head){
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;       
    }
    /**
     * !设 环的长度为A,慢指针在入环的时候快指针在环中的位置B(取值范围0到A-1),
     * ! 当快慢指针相遇时 [慢指针在环中走了C] ,有
     **C % A = ( B + 2C) % A,等价于 
     ** An + C = B + 2C,合并得
     ** C = An - B
     ** 当 n=1 时 , 0 <= C < A
     *! 故 慢指针在第一圈必定能和快指针相遇
     */
}
// @lc code=end

