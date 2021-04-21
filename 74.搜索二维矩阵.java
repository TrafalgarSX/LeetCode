/*
 * @Author: guo yawen
 * @Date: 2021-04-21 17:11:44
 * @LastEditTime: 2021-04-21 17:47:37
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\74.搜索二维矩阵.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
class Solution {
    public void transfer(int mid, int[] cor, int high, int width){
        cor[0] = mid / width;
        cor[1] = mid % width;

    }
    /**
     * *整体二分法,坐标转换即可。还有一种两次二分法的解法（可以处理不定长二维数组）
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0, right = matrix.length * matrix[0].length - 1;
        int mid, index;
        int[] cor = new int[2];
        while (left <= right) {
            mid = left + (right - left) / 2;
            transfer(mid, cor, matrix.length, matrix[0].length);
            if(matrix[cor[0]][cor[1]] == target){
                return true;
            }else if(matrix[cor[0]][cor[1]] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
// @lc code=end

