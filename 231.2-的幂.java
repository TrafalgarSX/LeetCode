/*
 * @author: guo yawen
 * @Date: 2021-06-21 16:25:12
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\231.2-的幂.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwoMine(int n) {
        if( n <= 0 ) return false;
        n = n & n - 1;
        return n == 0 ;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & -n) == n;
    }
}
// @lc code=end

