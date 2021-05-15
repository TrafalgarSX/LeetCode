/*
 * @Author: guo yawen
 * @Date: 2021-05-15 23:33:43
 * @LastEditTime: 2021-05-16 00:01:34
 * @LastEditors: guo yawen
 * @Descript:
 * @FilePath: \LeetCode\67.二进制求和.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    /**
     * *字符串相加，二进制版
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder ret = new StringBuilder();
        int m = a.length(), n = b.length();
        int count = Math.min(m, n);
        int i = m - 1, j = n - 1;
        int x, y, carry = 0;
        for( ; i >= 0 && j >= 0; i--,j--){
            x = a.charAt(i) - '0';
            y = b.charAt(j) - '0';
            ret.append(x ^ y ^ carry);
            carry = (x + y + carry) >> 1;
        }
        while( i >= 0){
            x = a.charAt(i) - '0';
            ret.append( x ^ carry);
            carry = (x + carry) >> 1;
            i--;
        }
        while( j >= 0){
            y = b.charAt(j) - '0';
            ret.append( y ^ carry);
            carry = (y + carry) >> 1;
            j--;
        }
        if(carry == 1){
            ret.append(carry);
        }
        ret.reverse();
        return ret.toString();
    }
}
// @lc code=end

