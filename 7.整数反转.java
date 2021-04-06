
/*
 * @Author: your name
 * @Date: 2021-03-30 23:53:06
 * @LastEditTime: 2021-03-31 13:32:52
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\7.整数反转.java
 */
/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            //这里判断是否会越界溢出的情况很经典
            if(result > Integer.MAX_VALUE/10 ||(result == Integer.MAX_VALUE && x % 10 > 7) ){
                return 0;
            }
            if(result < Integer.MIN_VALUE/10 ||(result == Integer.MIN_VALUE/10 && x % 10 < -8) ){
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;

        }
        return result;
    }
}
// @lc code=end

