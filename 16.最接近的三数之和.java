import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-04-14 15:26:52
 * @LastEditTime: 2021-04-14 22:51:36
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\16.最接近的三数之和.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ret = 0;
        Arrays.sort(nums);
        int left, right;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            left = i + 1;
            right = nums.length -1;
            while(left < right){
                int num = target - nums[left] - nums[right] - nums[i];
                if( Math.abs(num) < min){
                    min = Math.abs(num);
                    ret = target - num;
                }
                //!三数之和大于target
                if(num < 0){
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    right--;
                }else{
                //!三数之和小于target
                    while(left < right && nums[left] == nums[left+1]) left++;
                    left++;
                }
            }
        }
        return ret ;
    }
}
// @lc code=end

