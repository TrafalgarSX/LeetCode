/*
 * @Author: guo yawen
 * @Date: 2021-04-07 23:37:23
 * @LastEditTime: 2021-04-08 00:02:08
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\13.罗马数字转整数.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    private int  getValue(char c){
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:
                return 0;
        }
    }
    public int romanToInt(String s) {
        int sum = 0;
        int i = 0;
        int len = s.length();
        for (; i + 1 < len; i++) {
            if(getValue(s.charAt(i) )< getValue(s.charAt(i+1))){
                sum += getValue(s.charAt(i+1)) - getValue(s.charAt(i));
                i++;
            }else{
                sum += getValue(s.charAt(i));
            }
        }
        if( i == len-1){
            sum += getValue(s.charAt(i));
        }
        return sum;
    }
}
// @lc code=end

