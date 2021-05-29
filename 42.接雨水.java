/*
 * @Author: guo yawen
 * @Date: 2021-05-29 15:08:34
 * @LastEditTime: 2021-05-29 21:32:10
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\42.接雨水.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    /**
     * *还有一个单调栈解法， 看不太懂，以后再说。
     * @param height
     * @return
     */
    /**
     * *动态规划方法
     * * 原理： 求接雨水的总数，就是求每个柱子能存储多少水的总和
     * * 每个柱子存储多少水的算法是： 找到该柱子左侧最大值leftMax，和右侧最大值rightMax，
     * * 然后 Math.min(leftMax,rightMax) - height
     */
    public int trapDP(int[] height) {
        int n = height.length;
        if(n == 0){
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * *两面包夹芝士
     * *从两侧到中间
     * *原理：如果height[left] < height[right]，那么leftMax一定小于 rightMax
     * * 如果height[left] >= height[right]，那么rightMax一定小于leftMax
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left] < height[right]){
                ans += leftMax - height[left];
                left++;
            }else{
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
// @lc code=end

