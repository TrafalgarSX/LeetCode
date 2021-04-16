/*
 * @Author: guo yawen
 * @Date: 2021-04-15 13:24:43
 * @LastEditTime: 2021-04-16 23:09:06
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\10.正则表达式匹配.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    //!动态规划
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        //*动态规划数组 这样写，是字符串 划分串的常用写法，不是用来获取字符的。
        /**
         * *i 用来划分串的时候：
         * *i     0   1   2   3
         * *串    | a | b | c |
         */
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        //* 空串 和 空串 能够匹配
        dp[0][0] = true;
        /**dp
         * ?如果确定循环的范围?
         * * dp[0][0] 对应的是两个空串，可以匹配，所以 dp[0][0] = True。
         * *当 i = 0，j != 0 的时候 s 为空串，p 不为空串，这时候是有可能匹配上的，比如 s = ""， p = "a*"，这一行要加入循环。
         * *当 j = 0，i != 0 时，s 不为空，p 为空，这时一定不能匹配上，可以不加入循环，否则要判断 j > 0。
         */
        for (int i = 0; i < sLen + 1; i++) {
            for (int j = 1; j < pLen + 1; j++) {
               if(p.charAt(j - 1) != '*') {
                    if(mathchs(s, p, i, j)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = false;
                    }
               }else if(p.charAt(j - 1) == '*'){
                    //*匹配 0 次
                    dp[i][j] = dp[i][j - 2];
                    if(mathchs(s, p, i, j - 1)){
                        dp[i][j] = dp[i - 1][j] || dp[i][j];
                    }
               }
            }
        }
        return dp[sLen][pLen];
    }
    public boolean mathchs(String s, String p, int i, int j){
        //* i = 0 时 s是空串,不可能和 p匹配
        if(i == 0){
            return false;
        }
        //!这里的 i j 是用来划分字串的， i - 1 , j - 1才能用来获取字符
        return s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.';
    }
}
// @lc code=end

