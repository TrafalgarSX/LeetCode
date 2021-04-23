/*
 * @Author: guo yawen
 * @Date: 2021-04-23 12:24:52
 * @LastEditTime: 2021-04-23 12:35:59
 * @LastEditors: guo yawen
 * @Description:
 * @FilePath: \LeetCode\64.最小路径和.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + grid[0][i];
        }
        for (int q = 1; q < m; q++) {
            for (int i = 0; i < n; i++) {
               if(i == 0){
                   dp[i] = dp[i] + grid[q][i];
                   continue;
               }
               dp[i] = Math.min(dp[i], dp[i-1]) + grid[q][i];
            }
        }
        return dp[n-1];
    }
}
// @lc code=end

