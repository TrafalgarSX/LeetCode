import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Author: guo yawen
 * @Date: 2021-04-18 21:33:35
 * @LastEditTime: 2021-04-18 23:03:25
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\51.n-皇后.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
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
    public ArrayList<String> deepCopy(ArrayList<String> solution){
        ArrayList<String> copy = new ArrayList<>();
        for (String string : solution) {
            copy.add(string);
        }
        return copy;
    }
    public void backTrack(ArrayList<String> solution, int layer, char[] strLayer, int n, List<List<String>> ret,
                          Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2){
        if(layer == n){
            /**
             * !构造函数的方式是浅复制，拷贝的是引用。
             * *ret.add(new ArrayList<>(solution));
             */
            ret.add(deepCopy(solution));
            return;
        }

        Arrays.fill(strLayer, '.');
        for (int i = 0; i < n; i++) {
            if(valid(layer, i , columns, diagonals1, diagonals2)){
                strLayer[i] = 'Q';
                solution.add(new String(strLayer));
                columns.add(i);
                diagonals1.add(layer - i);
                diagonals2.add(layer + i);
                backTrack(solution, layer + 1, strLayer, n, ret, columns, diagonals1, diagonals2);
                strLayer[i] = '.';
                solution.remove(solution.size() - 1);
                columns.remove(i);
                diagonals1.remove(layer - i);
                diagonals2.remove(layer + i);
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        char[] in = new char[n];
        Arrays.fill(in, '.');
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backTrack(new ArrayList<String>(), 0, in, n, ret, columns, diagonals1, diagonals2);
        return ret;
    }
}
// @lc code=end

