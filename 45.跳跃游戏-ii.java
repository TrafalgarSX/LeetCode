/*
 * @Author: guo yawen
 * @Date: 2021-05-12 22:10:50
 * @LastEditTime: 2021-05-12 23:03:29
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\45.跳跃游戏-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    /**
     * *贪心法
     * *思想很有意思
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int end = 0;
        int time = 0; 
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if( i == end){
                end = maxPosition;
                time++;
            }
        }
        return time;
    }
}
// @lc code=end

