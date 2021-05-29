/*
 * @Author: guo yawen
 * @Date: 2021-05-29 21:33:44
 * @LastEditTime: 2021-05-29 21:41:08
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\58.最后一个单词的长度.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {

    public int lengthOfLastWord(String s) {
        boolean  flag = true;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(flag && s.charAt(i) == ' '){
                continue;
            }if( s.charAt(i) == ' ' && !flag ){
                break;
            }if(flag){
                flag = false;
            }
            ans++;
        }
        return ans;
    }
    /**
    **   String[] strings = s.split(" ");
    **    if(strings.length == 0){
    **        return 0;
    **    }
    **    return strings[strings.length - 1].length();
     */
}
// @lc code=end

