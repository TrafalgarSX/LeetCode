
/*
 * @author: guo yawen
 * @Date: 2021-06-16 10:44:39
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\172.阶乘后的零.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
import java.math.BigInteger;
class Solution {
    /**
     * *需要使用BigInteger类型，否则会出现溢出的情况，结果就不对了
     * *阶乘的方法太慢了。
     * @param n
     * @return
     */
    public BigInteger factorial(int n){
        if( n == 0 ){
            return BigInteger.ONE;
        }
        BigInteger  ans = BigInteger.ONE;
        while(n != 1){
            ans  = ans.multiply(BigInteger.valueOf(n)); 
            --n;
        }
        return ans;
    }
    public int trailingZeroesBrutal(int n) {
        int ret = 0; 
        BigInteger zero;
        zero = factorial(n);
        System.out.println(zero);
        while(zero.mod(BigInteger.TEN).equals(BigInteger.ZERO)){
            zero = zero.divide(BigInteger.TEN);
            ++ret;
        }
        return ret;
    }

    public int trailingZeroes(int n) {
        int ret = 0;
        while(n > 0){
            ret += n / 5;
            n = n / 5;
        }
        return ret;
    }
}
// @lc code=end

