/*
 * @Author: your name
 * @Date: 2021-03-31 13:33:24
 * @LastEditTime: 2021-03-31 15:12:36
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\8.字符串转换整数-atoi.java
 */
/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    //普通解法，还有一种 DFA 自动状态机的解法。
    public int myAtoi(String s) {
       // remove leading and trailing space
        
        s = s.trim();
        //注意判断 字符串为空 或者 字符串中只有 空格的情况
        if(s == null || s.length() ==0){
            return 0;
        }
 
        int flag = 1;
        //字符串开头为 - 或者 + 的情况 要考虑到
        if (s.charAt(0)=='-') {
            flag = -1;
            s = s.substring(1,s.length());
        }else if(s.charAt(0)=='+'){
            s = s.substring(1,s.length());
        }
        //正式开始计算
        int result = 0;
        for (char c: s.toCharArray()) {

           if (Character.isDigit(c)) {
                int num = c - '0';
                //考虑结果溢出的情况
                if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && num*flag > 7)){
                     return Integer.MAX_VALUE;
                }
                if(result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE/10 && num*flag < -8)){
                    return Integer.MIN_VALUE;
                }
                result = result * 10 + num*flag; 
           }else{
               //如果出现 非数字 就结束 计算，返回之前计算的结果。
               return result;
           } 
        }
       return result; 
    }
}

// @lc code=end

