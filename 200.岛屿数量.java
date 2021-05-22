import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: guo yawen
 * @Date: 2021-05-22 22:07:07
 * @LastEditTime: 2021-05-22 23:30:10
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\200.岛屿数量.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    int[] dir = {0,1,0,-1,0};
    public void dfs(char[][] grid, int x, int y) {

        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int x_idx = x + dir[i];
            int y_idx = y + dir[i + 1];
            if(x_idx >=0 && x_idx <grid.length && y_idx >= 0 && y_idx <grid[0].length && grid[x_idx][y_idx] == '1'){
                dfs(grid, x_idx, y_idx);
            }
        }
    }
    /**
     * *求连通子图的个数 深度优先
     */
    public int numIslandsDfs(char[][] grid) {
        int ret = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    ++ret;
                }
            }
        }
        return ret;
    }
    class Index{
        int x;
        int y;
        public Index(){

        }
        public Index(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int ret = 0;   
        int numCol = grid[0].length;
        int index, row, col;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    ++ret;
                    grid[i][j] = '0';
                    queue.add(i * numCol +j);
                    while(!queue.isEmpty()){
                        index= queue.poll();
                        row = index / numCol;
                        col = index % numCol;
                        /**
                         * *不知道为什么写在这会超时，找到立即修改就不会超时。
                         * *难道是缓存的原因吗？
                         */
                        // grid[row][col] = '0';

                        for (int k = 0; k < 4; k++) {
                            int x = row + dir[k];
                            int y = col + dir[k + 1];
                            if(x >=0 && x < grid.length && y >= 0 && y < grid[0].length){
                                if(grid[x][y] == '1'){
                                    queue.add(x * numCol + y);
                                    grid[x][y] = '0';
                                }
                            }
                        }
                    }
                }
            }
        }
        return  ret;
    }
}
// @lc code=end

