/*
 * @Author: guo yawen
 * @Date: 2021-04-17 13:04:24
 * @LastEditTime: 2021-04-18 02:16:01
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\28.实现-str-str.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    //! KMP算法的实现
    public int strStr(String haystack, String needle) {

        return -1;
    }
    //!暴力法，有可能超出时间限制。
    public int strStrBrutal(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        int len = haystack.length();
        for (int i = 0; i < len; i++) {
            int idx = i;
            int j = 0;
            int nLen = needle.length();
            for (; j < nLen && idx < len; j++,idx++) {
                if(haystack.charAt(idx) != needle.charAt(j)){
                    break;
                }
            }
            if(j == nLen){
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

