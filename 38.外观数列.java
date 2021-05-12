/*
 * @Author: guo yawen
 * @Date: 2021-05-12 20:34:23
 * @LastEditTime: 2021-05-12 21:14:25
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\38.外观数列.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String recursion(String numText, int n, int time){
        StringBuilder ret = new StringBuilder();
        int count = 0;
        char pre = numText.charAt(0);
        for (char ch : numText.toCharArray()) {
            if(ch != pre){
                ret.append(count);
                ret.append(pre);
                count = 1;
                pre = ch;
            }else{
                count++;
            }
        }
        ret.append(count);
        ret.append(pre);
        time++;

        if(time == n){
            return ret.toString();
        }
        return recursion(ret.toString(), n, time);
        
    }
    public String countAndSay(int n) {
        if( n == 1){
            return "1";
        }
        String ret = recursion("1", n, 1);
        return ret;
    }
}
// @lc code=end

