/*
 * @Author: guo yawen
 * @Date: 2021-06-01 12:27:17
 * @LastEditTime: 2021-06-01 14:13:19
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\55.跳跃游戏.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    /**
     * *得到最远能够跳到的下标，然后和最后一个下相比
     * *注意你跳到的位置必须能够达到。
     */
    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(i > maxPosition) break;
            maxPosition = Math.max(i + nums[i], maxPosition);

        }
        return maxPosition >= nums.length - 1 ? true : false;
    }
}
// @lc code=end

