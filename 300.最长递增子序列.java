/*
 * @Author: guo yawen
 * @Date: 2021-05-24 19:09:46
 * @LastEditTime: 2021-05-24 19:35:00
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\300.最长递增子序列.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    /**
     * * 动态规划公式dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxAns = 1;       
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxAns = Math.max(maxAns, dp[i]);
        }

        return  maxAns;
       }
}
// @lc code=end

