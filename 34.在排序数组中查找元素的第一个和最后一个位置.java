/*
 * @Author: guo yawen
 * @Date: 2021-04-10 23:09:14
 * @LastEditTime: 2021-04-12 19:07:07
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
    /**
     * ! https://www.zhihu.com/question/36132386/answer/530313852 二分法细节讲解
     * ! 关于 while (left <= right) 写法返回值的详细讨论  https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/da-jia-bu-yao-kan-labuladong-de-jie-fa-fei-chang-2/
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 ) {
            return new int[]{-1,-1};
        }
        // x >= value;
        int[] index = {-1,-1};
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                right = mid ;
            }else if( nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        if(left == nums.length ||( nums[left] != target)){
            index[0] = -1;
        }else{
            index[0] = left;
        }

        left = 0;
        right = nums.length;
        // x > value;
        while (left < right) {
            int mid = left + ( right - left ) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid; 
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        if (left == 0 || nums[left-1] != target) {
            index[1] = - 1;
        }else{
            index[1] = left -1;
        }
        return index;
    }
}
// @lc code=end

