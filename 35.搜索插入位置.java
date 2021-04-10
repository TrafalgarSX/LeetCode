/*
 * @Author: guo yawen
 * @Date: 2021-04-10 23:47:24
 * @LastEditTime: 2021-04-10 23:51:28
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\35.搜索插入位置.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target){
                left = mid + 1;               
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        //最后left就是 target应该插入的位置
        return left;
    }
}
// @lc code=end

