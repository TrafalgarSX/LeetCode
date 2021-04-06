/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    //动态规划法
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = Integer.MIN_VALUE;
        for (int i : prices) {
            cost = Math.min(cost,i);
            profit = Math.max(profit,i - cost);
        }
        return profit;
    }
}
// @lc code=end

