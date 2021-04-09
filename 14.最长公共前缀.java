/*
 * @Author: guo yawen
 * @Date: 2021-04-09 16:29:25
 * @LastEditTime: 2021-04-09 16:45:56
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\14.最长公共前缀.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String commonPrefix(String first, String second)
    {
        StringBuilder ret = new StringBuilder();
        int len = Math.min(first.length(),second.length());
        for (int j = 0; j < len; j++) {
            if(first.charAt(j) == second.charAt(j)){
                ret.append(first.charAt(j));
            }else{
                break;
            }
        }

        return ret.toString();
    }
    //本人采用分治法， 本题还可以用较简单的横向扫描，一个一个的匹配
    //也可以使用 纵向扫描 从上到下
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        return longestCommonPrefix(strs,0, strs.length);
    }
    public String longestCommonPrefix(String[] strs,int left, int right){
        if(left + 1 == right){
            return strs[left];
        }
        int mid = (left + right) / 2;
        String first = longestCommonPrefix(strs,left, mid);
        String second = longestCommonPrefix(strs, mid, right);

        return commonPrefix(first, second);
    }
}
// @lc code=end

