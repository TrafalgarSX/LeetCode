/*
 * @Author: guo yawen
 * @Date: 2021-04-09 19:52:25
 * @LastEditTime: 2021-04-09 20:31:37
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\213.打家劫舍-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
import java.util.*;
class Solution {
    public int normalRob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        int[] nums2 = new int[nums.length-1];
        int i = 1, j = 0;
        for (; i < nums.length; i++, j++) {
            nums2[j] = nums[i];
        }

        int[] nums3 = new int[nums.length-1];
        i = 0; 
        j = 0;
        for (; i < nums.length-1; i++, j++) {
            nums3[j] = nums[i];
        }
        return Math.max(normalRob(nums3),normalRob(nums2));
        
    }
}
// @lc code=end

