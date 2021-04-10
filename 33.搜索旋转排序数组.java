/*
 * @Author: guo yawen
 * @Date: 2021-04-10 08:42:41
 * @LastEditTime: 2021-04-10 23:06:59
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\33.搜索旋转排序数组.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                return i;
            }
        }
       return -1;
    }
}
// @lc code=end

