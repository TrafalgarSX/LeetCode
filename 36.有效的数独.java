import java.util.HashMap;

/*
 * @Author: guo yawen
 * @Date: 2021-05-12 19:35:08
 * @LastEditTime: 2021-05-12 20:30:50
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\36.有效的数独.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    /**
     * *扫描一遍，但是将用三个HashMap,将元素映射到相应的HashMap中
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        //* init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
           rows[i] = new HashMap<>();
           cols[i] = new HashMap<>();
           boxes[i] = new HashMap<>(); 
        }
        char num;
        int n, boxesIndex;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                num = board[i][j];
                if(num != '.'){
                    n = (int) num;
                    boxesIndex = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    cols[j].put(n, cols[j].getOrDefault(n, 0) + 1);
                    boxes[boxesIndex].put(n, boxes[boxesIndex].getOrDefault(n, 0) + 1);

                    //*check if this value  has been already seen before
                    if(rows[i].get(n) > 1 || cols[j].get(n) > 1 || boxes[boxesIndex].get(n) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     * *暴力法, 三次循环
     * @param board
     * @return
     */
    public boolean isValidSudokuBrutal(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i  < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    if(set.contains(board[i][j])){
                        return false;
                    }else{
                        set.add(board[i][j]);
                    }
                }
            }
            set.clear();
        }
        for(int i = 0; i  < board[0].length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != '.'){
                    if(set.contains(board[j][i])){
                        return false;
                    }else{
                        set.add(board[j][i]);
                    }
                }
            }
            set.clear();
        }
        for(int i = 0; i < board.length; i+=3){
            for(int j = 0; j < board[0].length; j += 3){

                for(int q = i; q < i + 3; q++){
                    for(int w = j; w < j + 3; w++){
                        if(board[q][w] != '.'){
                            if(set.contains(board[q][w])){
                                return false;
                            }else{
                                set.add(board[q][w]);
                            }
                        }
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
// @lc code=end

