import java.util.ArrayList;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-04-29 21:41:10
 * @LastEditTime: 2021-04-29 22:43:52
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\39.组合总和.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
/**
 * * 搜索可行解的问题都可以尝试用 搜索回溯的方法来解决。
 * * 无重复元素 && 所有数字都为正整数
 * * 解集不会出现重复的解
 */
class Solution {
    public void backTrack(int target, int idx, int[] candidates, ArrayList<Integer> in, List<List<Integer>> ret){
        if(idx == candidates.length){
            return;
        }
        if(target == 0){
            ret.add(new ArrayList<>(in));
            return;
        }
        int num = target - candidates[idx];
        /**
         * *选择当前数
         */
        if(num >= 0){
            in.add(candidates[idx]);
            backTrack(num, idx, candidates, in, ret);
            in.remove(in.size() - 1);
        }
        //* 跳过当前数
        backTrack(target, idx + 1, candidates, in, ret);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        backTrack(target, 0, candidates, new ArrayList<>(), ret);
        return ret;
    }
}
// @lc code=end

