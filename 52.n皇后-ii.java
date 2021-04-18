import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

/*
 * @Author: guo yawen
 * @Date: 2021-04-18 23:05:53
 * @LastEditTime: 2021-04-18 23:29:25
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\52.n皇后-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 */

// @lc code=start
class Solution {
    public boolean valid(int row, int col, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        boolean ret = true;
        if(columns.contains(col)){
            ret = false;
        }
        if(diagonals1.contains(row - col)){
            ret = false;
        }
        if(diagonals2.contains(row + col)){
            ret = false;
        }
        return ret;
    }
    public ArrayList<String> generateAll(int[] queens){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            char[] strLayer = new char[queens.length];
            Arrays.fill(strLayer, '.');
            strLayer[queens[i]] = 'Q';
            list.add(new String(strLayer));
        }
        return list;
    }
    public void backTrack(int layer, int n,
                          Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(layer == n){
            ret++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if(valid(layer, i, columns, diagonals1, diagonals2)){
                // queens[layer] = i;
                columns.add(i);
                diagonals1.add(layer - i);
                diagonals2.add(layer + i);
                backTrack(layer + 1, n, columns, diagonals1, diagonals2);
                // queens[layer] = -1;
                columns.remove(i);
                diagonals1.remove(layer - i);
                diagonals2.remove(layer + i);
            }
        }
    }
    int ret;
    public int totalNQueens(int n) {
        // int[] queens = new int[n];
        // Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backTrack(0, n, columns, diagonals1, diagonals2);
        return ret;
        
    }
}
// @lc code=end

