import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-04-29 22:39:48
 * @LastEditTime: 2021-04-30 23:31:27
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\40.组合总和-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
/**
 * * 所有元素都是正整数 && 可能有重复数字
 */
class Solution {

    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();
    List<int[]> freq = new ArrayList<>();
    public void backTrack(int idx, int target){
        if(target == 0){
            ret.add(new ArrayList<>(combine));
            return;
        }
        if(idx == freq.size() || freq.get(idx)[0] > target){
            return;
        }
        for (int i = 0; i <= freq.get(idx)[1]; i++) {
            for (int j = 0; j < i; j++) {
                combine.add(freq.get(idx)[0]);
            }           

            backTrack(idx + 1, target - i * freq.get(idx)[0]);

            for (int j = 0; j < i; j++) {
                combine.remove(combine.size() - 1);
            }
        }
       
    }
    public void backTrackBetter(int idx, int target){
        if(target == 0){
            ret.add(new ArrayList<>(combine));
            return;
        }
        if(idx == freq.size() || freq.get(idx)[0] > target){
            return;
        }
        backTrackBetter(idx + 1, target);
        /**
         * * 剪枝， i * freq.get(idx)[0] > target的剪去
         * *下面循环这样写比我自己写的好，更快，不用嵌套两次循环。
         * * 从 1 开始是因为上面已经 跳过 使用当前 值了。
         */
        int most = Math.min(target / freq.get(idx)[0], freq.get(idx)[1]);
        for (int i = 1; i <= most; i++) {
            combine.add(freq.get(idx)[0]);
            backTrack(idx + 1, target - i * freq.get(idx)[0]);
        }
        for (int i = 1; i <= most; i++) {
            combine.remove(combine.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if(freq.isEmpty() || num != freq.get(size - 1)[0]){
                freq.add(new int[]{num, 1});
            }else{
                ++freq.get(size - 1)[1];
            }
        }
        // backTrack(0, target );
        backTrackBetter(0, target);
        return ret;
    }
}
// @lc code=end

