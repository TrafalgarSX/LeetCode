/*
 * @Author: guo yawen
 * @Date: 2021-04-06 14:34:51
 * @LastEditTime: 2021-04-06 14:46:58
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\59.螺旋矩阵-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    //这样写比第一个螺旋矩阵更加简洁明了。
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        int left = 0,right = n - 1;
        int top = 0,bottom = n - 1;
        int all = n*n;
        while (count <= all) {
            for(int i = left; i <= right; i++){
                matrix[top][i] = count;
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count;
                count++;
            }
            right--;
            for (int i = right; i >= left; --i){
                matrix[bottom][i] = count;
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top; --i){
                matrix[i][left] = count;
                count++;
            }
            left++;
        }
        return matrix;
    }
}
// @lc code=end

