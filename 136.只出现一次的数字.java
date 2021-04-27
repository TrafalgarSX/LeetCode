/*
 * @Author: guo yawen
 * @Date: 2021-04-27 18:06:27
 * @LastEditTime: 2021-04-27 18:07:31
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\136.只出现一次的数字.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }
}
// @lc code=end

