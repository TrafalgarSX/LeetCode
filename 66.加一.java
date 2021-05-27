import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @Author: guo yawen
 * @Date: 2021-05-27 18:06:41
 * @LastEditTime: 2021-05-27 19:40:46
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\66.加一.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0, right = digits.length - 1;
        for (; right >=0; right--) {
            digits[right]++;
            digits[right] %= 10;
            if(digits[right] != 0)
                return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
// @lc code=end

