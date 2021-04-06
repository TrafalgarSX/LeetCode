/*
 * @Author: guo yawen
 * @Date: 2021-03-31 23:28:24
 * @LastEditTime: 2021-04-05 00:45:35
 * @LastEditors: guo yawen
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\150.逆波兰表达式求值.java
 */
/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start
import java.util.*;
class Solution {
    public int evalRPN(String[] tokens) {
        
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            for (String str: tokens) {
                try {
                //这里可以用 isNumber来判断，try-catch太慢了。
                 int number = Integer.parseInt(str); 
                 stack.push(number);
                } catch (Exception e) {
                    //TODO: handle exception
                   char ch = str.charAt(0);
                   //出栈顺序，除法对出栈顺序有要求。
                   int b = stack.pop();
                   int a = stack.pop();
                   if(ch == '*') stack.push(a*b);
                   if(ch == '/') stack.push(a/b);
                   if(ch == '+') stack.push(a+b);
                   if(ch == '-') stack.push(a-b);

                }
            }
            result = stack.pop();
            return result;  
    }

    public boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }

}
// @lc code=end

