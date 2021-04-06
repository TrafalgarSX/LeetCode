import jdk.nashorn.api.tree.ForInLoopTree;

/*
 * @Author: your name
 * @Date: 2021-03-31 15:16:50
 * @LastEditTime: 2021-03-31 15:52:09
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\11.盛最多水的容器.java
 */
/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while(left < right){
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            if( max < h * w){
                max = h * w;
            }
            if( height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max; 
    }
        //暴力法  超过时间限制
    public int maxAreaBrutal(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
           for (int j = i+1; j < height.length; j++) {
              int  h = Math.min(height[i], height[j]);
              int  w = j - i;
              if( max < h * w){
                  max = h * w;
              }
           } 
        }
        return max;
    }
}
// @lc code=end

