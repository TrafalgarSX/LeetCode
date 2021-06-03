import java.util.ArrayList;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-06-02 21:37:47
 * @LastEditTime: 2021-06-03 23:43:24
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\77.组合.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> in = new ArrayList<>();
    public void backTrack(int[] nums, int k,int i){

        if(in.size() == k){
            ret.add(new ArrayList<>(in));
            return;
        }
        /**
         * *可以剪枝
         */
        if(i == nums.length){
            return;
        }
        in.add(nums[i]);
        backTrack(nums, k, i + 1);
        in.remove(in.size() - 1);
        backTrack(nums, k, i + 1);
    }
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i < n + 1; i++) {
            nums[i - 1] = i;
        }
        backTrack(nums, k, 0 );
        return ret;
    }
}
// @lc code=end

