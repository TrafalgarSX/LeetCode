import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/*
 * @author: guo yawen
 * @Date: 2021-06-22 14:35:34
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\71.简化路径.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] strs = path.split("/");
        for (int i = 0; i < strs.length; i++) {
            if( "..".equals(strs[i]) && !stack.isEmpty()){
                stack.pollLast();
            }else if(!".".equals(strs[i]) && !"..".equals(strs[i])  && !"".equals(strs[i])){
                stack.offer(strs[i]);
            }
        }
        return "/"+ String.join("/", stack);
    }
}
// @lc code=end

