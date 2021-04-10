/*
 * @Author: guo yawen
 * @Date: 2021-04-10 23:09:14
 * @LastEditTime: 2021-04-10 23:44:36
 * @LastEditors: guo yawen
 * @Description: 二分法经典应用
 * @FilePath: \LeetCode\34.在排序数组中查找元素的第一个和最后一个位置.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 ) {
            return new int[]{-1,-1};
        }
        int[] index = new int[2];
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right- left) / 2;
            if(nums[mid] == target){
                right = mid ;
            }else if( nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }

        if (nums[left] == target) {
            index[0] = left;
        }else{
            index[0] = -1;
        }

        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + (right- left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid; 
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        if (nums[left-1] == target) {
            index[1] = left - 1;
        }else{
            index[1] = -1;
        }
        return index;
    }
}
// @lc code=end

