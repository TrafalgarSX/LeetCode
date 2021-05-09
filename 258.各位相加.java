/*
 * @Author: guo yawen
 * @Date: 2021-05-09 19:46:51
 * @LastEditTime: 2021-05-09 20:23:00
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\258.各位相加.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    /**
     * *能够被9整除的整数，各位上的数字加起来也必然能被9整除，所以，连续累加起来，最终必然就是9。
     * *不能被9整除的整数，各位上的数字加起来，结果对9取模，和初始数对9取摸，是一样的，所以，连续累加起来，最终必然就是初始数对9取摸。
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
    
    public int addDigitsLoop(int num) {
        while(num >= 10){
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
// @lc code=end

