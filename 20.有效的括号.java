/*
 * @Author: guo yawen
 * @Date: 2021-04-09 15:45:50
 * @LastEditTime: 2021-04-09 16:25:20
 * @LastEditors: guo yawen
 * @Description:    
 * @FilePath: \LeetCode\20.有效的括号.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
import java.util.*;
class Solution {
    public char match(char ch){
        switch (ch) {
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
            default:
            return '0';
        }
    }
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        char temp;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch(ch){
                case '(': stack.push(ch); break;
                case '{': stack.push(ch); break;
                case '[': stack.push(ch); break;
                case ')': {
                    if(stack.isEmpty()) return false;
                    temp = stack.pop();
                    if(match(ch) != temp){
                        return false;
                    }
                    break;
                }
                case '}': { 
                    if(stack.isEmpty()) return false;
                    temp = stack.pop();
                    if(match(ch) != temp){
                        return false;
                    }
                    break;
                }
                case ']': { 
                    if(stack.isEmpty()) return false;
                    temp = stack.pop();
                    if(match(ch) != temp){
                        return false;
                    }
                    break;
                }


            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

