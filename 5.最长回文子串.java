/*
 * @Author: guo yawen
 * @Date: 2021-03-30 13:26:02
 * @LastEditTime: 2021-04-05 00:49:16
 * @LastEditors: guo yawen
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\5.最长回文子串.java
 */
/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    //动态规划
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String ans = "";
        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i + len< s.length(); i++) {
                int j = i + len;
                if(len == 0){
                    dp[i][j] = true;
                }else if( len == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
                if(dp[i][j] && len + 1 > ans.length() ){
                    ans = s.substring(i,j+1);
                }
            }
        }
        return ans;
    }
    //中心扩展  时间复杂度：O(n^2),空间复杂度：O(1)。
    public String longestPalindrome_middle(String s) {
        if( s == null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i+1 );
            int len = Math.max(len1,len2);
            if (len > end - start +1) {
               start = i - (len - 1) / 2;
               end = i + (len/2); 
            }
        }
       
       return s.substring(start,end + 1);
    }
    public int expandAroundCenter(String s, int left ,int right){
        if (left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
           left--;
           right++; 
        }
        //注意，这里 left 和 right 不是想要字符串的边界， left+1 和 right -1才是
        return right - left - 1;
    }
}
// @lc code=end

