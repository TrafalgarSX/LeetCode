import java.util.ArrayList;

/*
 * @Author: guo yawen
 * @Date: 2021-04-06 14:49:38
 * @LastEditTime: 2021-04-08 14:04:09
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\73.矩阵置零.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
import java.util.*;
class Solution {
    class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int[] dir = {-1, 0, 1, 0, -1};
    public void setZeroes(int[][] matrix) {
        ArrayList<Node> list = new ArrayList<>();
        //得到每一个 0 结点的坐标
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ( matrix[i][j] == 0 ) {
                    list.add(new Node(i,j));
                }
            }
        }
        int width = matrix[0].length;
        int high = matrix.length;
        
        for (Node node : list) {
            //四个方向
            for (int i = 0; i < 4; i++) {
                int x = node.x;
                int y = node.y;   
                //每个方向都置零，直到边界。
                while ( x >= 0 && x < high && y >= 0 && y < width ) {
                    matrix[x][y] = 0;
                    x += dir[i];
                    y += dir[i+1];
                }
            }
        }
    }
    //官方方法，巨简单，上面的自己的方法想复杂了。 不是最简方法，有常量级空间复杂度的方法。
    public void setZeroesOfficial(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ( matrix[i][j] == 0 ) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ( row[i] || col[j] ) {
                    matrix[i][j] = 0;
                }
            }
        }


    }
}
// @lc code=end

