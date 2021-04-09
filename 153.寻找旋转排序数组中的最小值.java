/*
 * @Author: guo yawen
 * @Date: 2021-04-09 21:15:34
 * @LastEditTime: 2021-04-09 21:46:29
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\153.寻找旋转排序数组中的最小值.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    //O(logn) 的时间复杂度 可以
    //所以应该用二分法
    public int findMindichotomy(int[] nums){
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }
        } 
        return nums[left];
    }
    //O(n) 的时间复杂度 对于 1e9的数据量是不允许的
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
            }
        }
        return min;
    }
}
// @lc code=end

