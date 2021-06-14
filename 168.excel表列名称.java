/*
 * @author: guo yawen
 * @Date: 2021-06-14 22:32:09
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\168.excel表列名称.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    /**
     * *进制转换
     * *int quotient(商), remainder(余数);
     */
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        char[] Mapping = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
                          'H', 'I', 'J', 'K', 'L', 'M', 'N',
                          'O', 'P', 'Q',      'R', 'S', 'T',
                          'U', 'V', 'W',      'X', 'Y', 'Z'};
        columnNumber -= 1;
        while (columnNumber >= 0){
            ans.append(Mapping[columnNumber % 26]);
            columnNumber = (columnNumber / 26) - 1;
        }
        
        ans.reverse();
        return ans.toString();
    }
}
// @lc code=end

