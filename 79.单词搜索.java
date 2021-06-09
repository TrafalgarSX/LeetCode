/*
 * @Author: guo yawen
 * @Date: 2021-06-09 12:40:45
 * @LastEditTime: 2021-06-10 01:10:54
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\79.单词搜索.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    /**
     * *典中典， 深度优先搜索
     * * 剪枝的判断放在哪里，如何进行判断
     * * 递归中有循环，这种情况需要使用 flag变量标记结束
     * * 还需要visited数组，比较已访问过的元素
     * * visited数组赋值的位置
     * * 递归中有循环时的模式，本题典型， 判断数组是否出界，元素是否访问过。
     */
    int[] dir = {-1, 0, 1, 0, -1};
    boolean[][] visited;
    public boolean dfs(char[][] board, String word, int row, int col, int index){
        
        
        if(board[row][col] != word.charAt(index)){
            return false; 
        }
        if(index == word.length() - 1){
            return true;
        }

        visited[row][col] = true;
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int x = row + dir[i];
            int y = col + dir[i + 1];
            if( x >= 0 && x < board.length && y >= 0 && y < board[0].length){
                if(!visited[x][y]){

                    //visited[x][y] = true;
                    if(dfs(board, word, x, y, index + 1)){
                        flag = true;
                        break;
                    }
                    //visited[x][y] = false;
                }
            }

        }

        visited[row][col] = false;
        return flag;
    }
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

