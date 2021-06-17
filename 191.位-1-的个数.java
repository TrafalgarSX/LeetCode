/*
 * @author: guo yawen
 * @Date: 2021-06-17 11:31:42
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\191.位-1-的个数.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeightMine(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
    /**
     * *优化过的方法
     * *原理是  n & (n - 1) 可以把 n 的二进制位中的最低为 1 变为 0 
     */
    public int hammingWeight(int n) {
        int ans = 0;
        while(n != 0){
            n &= n - 1;
            ans ++;
        }
        return ans;
    }
}
// @lc code=end

