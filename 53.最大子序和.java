import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-04-19 14:13:35
 * @LastEditTime: 2021-04-19 17:59:25
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\53.最大子序和.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    /**
     * *dp数组的意义是 以第 i 个数结尾的「连续子数组的最大和」
     * *我们只需要求出每个位置的 dp(i)，然后返回 dp 数组中的最大值即可。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
// @lc code=end

