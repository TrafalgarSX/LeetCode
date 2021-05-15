/*
 * @Author: guo yawen
 * @Date: 2021-05-15 22:29:57
 * @LastEditTime: 2021-05-15 23:31:49
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\43.字符串相乘.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */


// @lc code=start
class Solution {
    /**
     * *数学上的方法
     * *由于num1 和num2 的乘积的最大长度为 m + n, 因此创建长度为m + n的数组 ansArr用于存储乘积
     * *对于任意 0<= i < m 和  0 <= j < n, num1[i] * num2[j] 的结果位于 ansArr[i + j +1],
     * *如果ansArr[i + j + 1] >= 10, 则将进位部分加到ansArr[i + j]。最后，将数组ansArr转成字符串，
     * *如果最高位是0，则舍弃最高位。
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        StringBuilder ret = new StringBuilder();
        if (num1.equals("0") || "0".equals(num2)) {
            return "0"; 
        }
        int m = num1.length(), n = num2.length();
        int[] array = new int[m + n];
        int x, y;
        for(int i = m - 1; i>= 0; i--){
            x = num1.charAt(i) - '0';
            for(int j = n - 1; j >= 0; j--){
                y = num2.charAt(j) - '0';
                array[i + j + 1] += x * y;
            }
        }
        for(int i = m + n - 1; i > 0 ; --i){
            array[i - 1] +=array[i] / 10;
            array[i] = array[i] % 10;
        }
        
        for (int i = array[0] == 0 ? 1 : 0; i < array.length; i++) {
            ret.append(array[i]);
        }
        return ret.toString();
    }
}
// @lc code=end

