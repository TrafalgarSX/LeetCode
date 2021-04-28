/*
 * @Author: guo yawen
 * @Date: 2021-04-27 18:12:03
 * @LastEditTime: 2021-04-28 22:54:09
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\190.颠倒二进制位.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    /**
     * *简单的思路，不要想的太麻烦了，循环即可
     * *把后面的放在前面就可以了。
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            ret |= (n & 1) << 31 - i;
            n >>>= 1;
        }
        return ret;
    }
}
// @lc code=end

