/*
 * @Author: guo yawen
 * @Date: 2021-04-07 22:16:47
 * @LastEditTime: 2021-04-08 01:03:36
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\12.整数转罗马数字.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
import java.util.*;
class Solution {
    //贪心 从大到小 循环遍历每个符号
    //检查当前符号的有多少个副本适合剩余的整数
    public String intToRoman(int num) {
        int[] values ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] roman ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder ret = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for(int i = 0; i < values.length && num > 0; i++){
        // Repeat while the current symbol still fits into num.
            while(num >= values[i]){
                num = num - values[i];
                ret.append(roman[i]);
            }
        }
        return ret.toString();
    }
    //硬编码法
    public String intToRomanHard(int num){
        
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; 
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];

    }
}
// @lc code=end

