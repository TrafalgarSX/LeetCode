/*
 * @Author: guo yawen
 * @Date: 2021-04-06 13:49:11
 * @LastEditTime: 2021-04-06 14:32:31
 * @LastEditors: guo yawen
 * @Description: 螺旋矩阵
 * @FilePath: \LeetCode\54.螺旋矩阵.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int high = matrix.length-1;
        int width = matrix[0].length-1;
        int left = 0;
        int top = 0;
        int row = 0,col = 0;
        List<Integer> list = new ArrayList<>();
        //这里break是一种方法，但很繁琐
        //可以计算矩阵共有多少格，然后每访问一个就 count--，然后while判断
        while (true) {
            for (col = left; col <= width; ++col){
                list.add(matrix[row][col]);
            }
            top++;
            col--;
            if (top > high) {
                break;
            }
            for(row = top ;row <= high; ++row ){
                list.add(matrix[row][col]);
            }
            width--;
            row--;
            if(width < left){
                break;
            }
            for(col = width;col >= left; --col){
                list.add(matrix[row][col]);
            }
            high--;
            col++;
            if (high < top) {
                break;
            }
            for(row = high;row >= top; --row ){
                list.add(matrix[row][col]);
            }
            left++;
            row++;
            if (left > width) {
                break;
            }
        }

        return list;
    }
}
// @lc code=end

