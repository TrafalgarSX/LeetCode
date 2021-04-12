/*
 * @Author: guo yawen
 * @Date: 2021-04-09 21:15:34
 * @LastEditTime: 2021-04-12 22:09:41
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
    //注意数组中没有重复 元素，所以可以 不用考虑 mid 和 right 的元素相等。
    /**
     * * Dichotomy 二分
     * !从集合的角度考虑：
     * ! 因为找的是最小值，所以数组中一定存在结果。
     * ! 找最小值，将 nums[mid] 与 nums[right] 相比（左闭右闭）
     * ! 若 nums[mid] < nums[right] ,说明mid 有可能是最小值，将区间 右指标 right = mid;
     * ! 若 nums[mid] > nums[right] ,说明mid 铁定不是最小值，将区间 左指标 left = mid + 1;
     * !直到 left == right 跳出循环， 这最后结果就是  最小值。
     * @param nums
     * @return
     */
    public int findMinDichotomy(int[] nums){
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

