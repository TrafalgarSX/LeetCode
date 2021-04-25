/*
 * @Author: guo yawen
 * @Date: 2021-04-24 21:55:49
 * @LastEditTime: 2021-04-25 18:38:03
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\48.旋转图像.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    /**
     ** 将数组顺时针旋转90度
     ** 先将数组上下翻转，然后按主对角线翻转，即完成 旋转90°
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        /**
         * *上下翻转
         */
        for (int i = 0; i < (n >> 1); i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j] ^ matrix[n - i - 1][j];
                matrix[i][j] = matrix[i][j] ^ matrix[n - i - 1][j];
            }
        }
        /**
         ** 按主对角线翻转
         */
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }
    }
    /**
     * *找规律旋转,难以想到，难以记忆。
     * @param matrix
     */
    public void rotate2(int[][] matrix){
        int temp;
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2 ; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n - j -1][i];
                matrix[n - j - 1][i] = matrix[n -i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
// @lc code=end
