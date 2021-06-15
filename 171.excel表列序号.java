/*
 * @author: guo yawen
 * @Date: 2021-06-15 14:02:35
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\171.excel表列序号.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            ans = (ans * 26 )+ columnTitle.charAt(i) - ('A' - 1);
        }
        return ans;
    }
}
// @lc code=end

