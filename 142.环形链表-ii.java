import java.util.HashSet;

/*
 * @Author: guo yawen
 * @Date: 2021-04-09 23:20:01
 * @LastEditTime: 2021-04-09 23:32:57
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
    public ListNode detectCycleNode(ListNode head){
        ListNode fast = head, slow = head;
        
        
    }
}
// @lc code=end

