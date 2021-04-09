/*
 * @Author: guo yawen
 * @Date: 2021-04-09 17:45:37
 * @LastEditTime: 2021-04-09 19:51:38
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\198.打家劫舍.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    /**
     * 
如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k~(k>2)k (k>2) 间房屋，有两个选项：

1. 偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 kk 间房屋的金额之和。

1. 不偷窃第 k 间房屋，偷窃总金额为前 k−1 间房屋的最高总金额。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }       
        return dp[nums.length-1];
    }
}
// @lc code=end

