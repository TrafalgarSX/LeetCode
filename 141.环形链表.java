import java.util.HashMap;

/*
 * @Author: guo yawen
 * @Date: 2021-04-09 21:00:41
 * @LastEditTime: 2021-04-09 21:12:27
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\141.环形链表.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
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
    //哈希法
    public boolean hasCycleHash(ListNode head) {

        HashSet<ListNode> map = new HashSet<>();
        while(head != null){
            if(map.contains(head)){
                return true;
            }else{
                map.add(head);
                head = head.next;
            }
        }
        return false;
    }

    //快慢指针法
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

