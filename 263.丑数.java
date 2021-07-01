/*
 * @author: guo yawen
 * @Date: 2021-07-01 23:32:53
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\263.丑数.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=263 lang=java
 *
 * [263] 丑数
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        //* 只包含 2，3，5 所以0 和负数都不是。
        if( n <= 0){
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while(n % factor == 0){
                n /= factor;
            }
        }
        return n == 1;
    }
}
// @lc code=end

