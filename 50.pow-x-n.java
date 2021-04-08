/*
 * @Author: guo yawen
 * @Date: 2021-04-06 14:47:07
 * @LastEditTime: 2021-04-08 13:47:11
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\50.pow-x-n.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    // n possible negative
    //快速幂算法，指数级增长。
    public double myPow(double x, int n) {
        //这里用long 是因为 -n 超过了 整数范围。
        long N = n;
        return n > 0 ? quickMul(x, N) : 1/quickMul(x, -N);
    }
    //递归方法
    public double quickMul(double x, long n){
        if( n == 0 ){
            return 1;
        }
        double y = quickMul(x, n / 2);
        // n 为奇数，多乘一个x， n 为偶数， y * y
        return n % 2 == 0 ? y * y : y * y * x;
    }
    //迭代方法
    public double quickMulIteration(double x, long n){
        double ret = 1;
        double tempRet = x;
        while(n > 0){
            if( (n & 1) == 1){
                ret = ret * tempRet;
            }
            tempRet *= tempRet;
            n /= 2;
        }
        
        return ret;
    }
}
// @lc code=end

