/*
 * @Author: guo yawen
 * @Date: 2021-06-05 12:37:41
 * @LastEditTime: 2021-06-05 13:03:24
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\125.验证回文串.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        
        StringBuilder mid = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                mid.append(s.charAt(i));
            }
        }
        int left = 0, right = mid.length() - 1;
        
        
        while(left < right){
            if(Character.toLowerCase(mid.charAt(left)) != Character.toLowerCase(mid.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;

    }
}
// @lc code=end

