/*
 * @Author: your name
 * @Date: 2021-04-01 21:32:34
 * @LastEditTime: 2021-04-01 22:07:37
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\415.字符串相加.java
 */
/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {

    public String addStrings(String num1, String num2) {
        StringBuilder ret = new StringBuilder();
        int carry = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        for (;i>=0 && j>=0 ; i--,j--) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            ret.insert(0, (a+b+carry)%10);
            carry =(a+b+carry) / 10;
        }
        while(i >= 0){
            int a = num1.charAt(i) - '0';
            ret.insert(0,(a+carry)%10);
            carry = (a+carry) / 10;
            i--;
        }
        while(j >= 0){
            int a = num2.charAt(j) - '0';
            ret.insert(0,(a+carry)%10);
            carry = (a+carry) / 10;
            j--;
        }
        if(carry != 0){
            ret.insert(0, carry);
        }
        return ret.toString();
    }

    public String addStringsOfficial(String num1, String num2) {
                int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
// @lc code=end

