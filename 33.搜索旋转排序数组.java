/*
 * @Author: guo yawen
 * @Date: 2021-04-10 08:42:41
 * @LastEditTime: 2021-04-13 01:06:49
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
    /**
     * * 数组中的值互不相同
     * ! 在数组中搜索 target, 有可能找不到。
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        //* 始终在局部有序的数组中找 target
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            }
             /**
             * ! 必须为 <= ,否则[3,1] 的情况不通过。
             * ! 虽然数组中值互不相等，但是 mid 有可能为0。
             * ! 当面临[3,1]的情况时，mid 和 0相等时，左侧是有序的。
             */
            //* 如果左侧有序
            if( nums[left] <= nums[mid] ){
                if( nums[mid] > target && nums[left] <= target ){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{ //*如果左侧无序，右侧则一定有序[mid,right].
                
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
        
    }
}
// @lc code=end

