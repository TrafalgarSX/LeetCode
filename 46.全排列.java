import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Author: guo yawen
 * @Date: 2021-04-19 10:07:31
 * @LastEditTime: 2021-04-19 13:11:16
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\46.全排列.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public void backTrack(int[] nums, int index, boolean[] used, ArrayList<Integer> figure, List<List<Integer>> ret){
        if(index == nums.length){
            // ret.add(Arrays.stream(nums)
            //                 .boxed()
            //                 .collect(Collectors.toList()));
            //* Java 回溯法中典型复制方法。
            ret.add(new ArrayList<>(figure));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                figure.add(nums[i]);
                backTrack(nums, index+1, used, figure, ret);
                figure.remove(index);
                used[i] = false;
            }
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(nums, 0, used, new ArrayList<>(), ret);
        return ret;
    }
}
// @lc code=end

