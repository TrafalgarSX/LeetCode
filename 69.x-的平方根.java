/*
 * @Author: guo yawen
 * @Date: 2021-04-06 12:09:05
 * @LastEditTime: 2021-04-06 13:48:59
 * @LastEditors: guo yawen
 * @Description:
 * @FilePath: \LeetCode\69.x-的平方根.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    //数学方法
    public int mySqrtMath(int x){
        if(x == 0){
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans+1 : ans;
    }
    //二分法
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right ) / 2;
            if ((long) mid * mid <= x) {
                left = mid +1;
                ans  = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
// @lc code=end

