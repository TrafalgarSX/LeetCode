import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public void backTrack(int[] nums, int index, boolean[] used, List<Integer> figure, List<List<Integer>> ret){
        if(index == nums.length){
            ret.add(new ArrayList<>(figure));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            /**
             * !used[i - 1] 不可以少
             * *当相邻两个相等，而且，前一个已经深度搜索过，
             * *回溯，然后前一个回复成未访问的状态后， 后一个相等的才可以因为占有的是相同的位置跳过，
             * *如果前一个访问过，后一个和他相等，但是他们占的不是相同的位置（进入下一层的递归），所以不会出现重复解。
             */
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1] ){
                continue;
            }
            if(!used[i]){
                used[i] = true;
                figure.add(nums[i]);
                backTrack(nums, index + 1, used, figure, ret);
                used[i] = false;
                figure.remove(index);

            }
                        
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, 0, used, new ArrayList<>(), ret);
        return ret;
    }
}
// @lc code=end

