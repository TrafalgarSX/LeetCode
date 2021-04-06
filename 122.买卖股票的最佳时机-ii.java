/*
 * @Author: your name
 * @Date: 2021-04-02 14:57:04
 * @LastEditTime: 2021-04-02 14:59:40
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\122.买卖股票的最佳时机-ii.java
 */
/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    //贪心法
    public int maxProfit(int[] prices) {
        int maxSum = 0;
        for (int i = 0; i+1 < prices.length; i++) {
            if(prices[i] < prices[i+1]){
                maxSum += prices[i+1] -prices[i];
            }
        }
        return maxSum;
    }
}
// @lc code=end

