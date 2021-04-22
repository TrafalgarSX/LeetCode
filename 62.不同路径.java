import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @Author: guo yawen
 * @Date: 2021-04-22 21:42:35
 * @LastEditTime: 2021-04-22 22:24:30
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\62.不同路径.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    class Node{
        int x;
        int y;
        public Node(){}
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    int[] dir = {1,0,1};
    /**
     * *广度优先算法超出时间限制
     * @param m
     * @param n
     * @return
     */
    public int bfs(int m, int n){
        Deque<Node> queue = new LinkedList<>();

        boolean[][] visited = new boolean[m][n];
        queue.offer(new Node(0,0));
        visited[0][0] = true;
        int ret = 0;
        Node curr;
        while(!queue.isEmpty()){
            curr = queue.poll();
            if(curr.x == m - 1 && curr.y == n - 1){
                ++ret;
            }
            for (int i = 0; i < 2; i++) {
                int x = curr.x + dir[i];
                int y = curr.y + dir[i + 1];
                if(x < m && y < n && !visited[x][y]){
                    queue.offer(new Node(x,y));
                }
            }
        }
        return ret;
    }
    /**
     * *动态规划方法，很简单。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    /**
     * *组合数学的方法
     * @param m
     * @param n
     * @return
     */
    public int uniquePathsMath(int m, int n){
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
// @lc code=end

