/*
 * @Author: your name
 * @Date: 2021-03-31 13:33:45
 * @LastEditTime: 2021-03-31 14:15:46
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\9.回文数.java
 */
/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    //simple method  need extra space to store number;
    public boolean isPalindrome(int x) {
       if(x < 0){
           return false;
       } 
       String numStr = String.valueOf(x);
       int left = 0 ,right = numStr.length()-1;
       while(left < right){
           if(numStr.charAt(left) != numStr.charAt(right)){
               return false;
           }
           left++;
           right--;
       }
       return true;
    }
    // official method , reverse half number;
    public boolean isPalindromeOfficial(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        // 当 剩下的数字 小于等于 reverse的时候就处理的一半以上的数字了。
        while (x > reverse) {
            reverse = reverse*10 + x % 10;
            x /= 10;           
        } 
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        if(x == reverse || x /10 == reverse){
            return true;
        }else{
            return false;
        }
    }
}

// @lc code=end

