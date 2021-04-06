/*
 * @Author: your name
 * @Date: 2021-04-02 15:08:15
 * @LastEditTime: 2021-04-05 00:44:02
 * @LastEditors: guo yawen
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\70.爬楼梯.java
 */
/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    //动态规划方法
    //边界情况，当 从0 到 0 有一种方法， 从 0 - 1有 一中方法
    public int climbStairs(int n) {
        int first = 1 , second = 2;
        if(n ==1){
            return 1;
        }
        for (int i = 3; i <=n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
    //递归方法，超时了
    public int climbStairsTraversal(int n){
        if (n == 1 || n ==0) {
            return 1;
        }
        return climbStairsTraversal(n-1) + climbStairsTraversal(n-2);
    }
    
}
// @lc code=end

