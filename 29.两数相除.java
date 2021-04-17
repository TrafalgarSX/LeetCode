/*
 * @Author: guo yawen
 * @Date: 2021-04-17 01:30:28
 * @LastEditTime: 2021-04-18 02:11:44
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\29.两数相除.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
import static java.lang.Math.*;
class Solution {
    //* bit manipulation 算法原理 泰勒展开
    /**
     * * 2的幂次的展开，任何一个数K可以被表示为
     * *K = b0 * 2^0 + b1 * 2^1 + b2 * 2^2 + ... + bn * 2^n + ...
     * !以下标注 除法中会出现的情况，并处理可能的错误
     * !negative numbers will play havoc with our bitwise shifting, 
     * !so we should first extract the sign difference and then use only positive numbers for A and B.
     * * 1、dividend > 0 && divisor > 0 不需要进行额外处理
     * * 2、dividend > 0 && divisor < 0 对divisor 取负后计算，最后将结果取负（有负号标记可以判断）
     * * 3、dividend < 0 && divisor > 0 对dividend 取负后计算，最后结果取负
     * * 4、dividend < 0 && divisor < 0 对两者取负并进行计算。
     * * 当 dividend == Integer.MIN_VALUE时，对dividend取负的结果会溢出，-(Integer.MIN_VALUE) == Integer.MIN_VALUE
     * * 所以情况三、四中，当 dividend == Integer.MIN_VALUE时，-2147483648 - 1 和 2147483648 - 1的作用是相同的。
     * !所以以上情况都可以 归为 一种情况 就是 dividend中包含几个 divisor。结果的符号，由符号标记变量 判断。
     * !将除数和被除数都用整数表示，然后 看被除数 包含几个除数（用减法比较，用位操作加速） 
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        //!除法溢出的情况，这是规定的特殊情况。
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean isNegative = false;
        //*获得符号标记变量
        isNegative = dividend > 0 == divisor > 0 ? false : true;
        //*获得符号标记变量的另一种写法
        // if(dividend < 0 || divisor < 0){
        //     isNegative = true;
        // }
        // if(dividend < 0 && divisor < 0){
        //     isNegative = false;
        // }
        int result = 0;
        int dd = Math.abs(dividend);
        int di = Math.abs(divisor);

        if(dd == di) return isNegative ? -1 : 1; //和下面注释的解法一匹配，为了解决-2147483648 -2147483648的情况
        for (int i = 0, val = di; dd - di>= 0; i = 0, val = di){
            /**
             * * 解法一 更好理解
             * !32-bit
             * !Java requires only a small change to the conditions on its loops to avoid an issue.
             * !当 dividend 为 -2147483648 时， val 有可能 为 -2147483648 或者其他
             * !这里的 val > 0 就是为了当val 进行位移计算时 出现溢出，那么他的大小肯定超过了 被除数，此时跳出循环。

             */
             while(val > 0 && dd - val >= 0) val = di << ++i;
             dd -= di << --i;
             result += 1 << i;
        }
        return isNegative ? -result : result;
    }
    /**
     * !数学上有误差。
     * * Logarithmic
     * *  if:  exp(log(c)) = c                   // Logarithmic rule #1
     * *  if:  log(a / b) = log(a) - log(b)     // Logarithmic rule #2* *
     * *then:  a / b = exp(log(a / b))          // From rule #1
     * *       a / b = exp(log(a) - log(b))     // From rule #2* *
     * *       (if m and n are > 0)
     * @param dividend
     * @param divisor
     * @return
     */
    public int divideLogarithmic(int dividend, int divisor) {

        boolean isNegative = false;
        //*获得符号标记变量
        isNegative = dividend > 0 == divisor > 0 ? false : true;
        int result = 0;
        if(divisor == Integer.MIN_VALUE){
            return dividend == divisor ? 1 : 0;
        }
        if(dividend == Integer.MIN_VALUE){
            if(divisor == 1)  return Integer.MIN_VALUE;
            if(divisor == -1) return Integer.MAX_VALUE;
            dividend +=abs(divisor);
            result++;
        }
        int dd = abs(dividend);
        int di = abs(divisor);
        result += floor(exp(log(dd) - log(di)));
        return isNegative ? -result : result;
    }
}
// @lc code=end


/**
 * !很操蛋的写法，不知道有什么 后面位移溢出 为什么可以进行判断正确。
 * //!上面注释中的另一种写法，该写法不需要 val变量。不好理解，还是用上面的好一点。感觉需要数学上的证明
 * //!因为他是先进行判断，如果出现溢出（正数溢出为负数）正数 减 负数,加起来会超过正数最大值又会溢出为负数。
 **         while(dd - (di << 1 << i) >= 0) i++;
 **         dd -= di << i;
 **         result += 1 << i;
 *   
 */;