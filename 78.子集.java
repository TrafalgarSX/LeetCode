import java.util.ArrayList;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-05-28 11:42:15
 * @LastEditTime: 2021-05-28 17:05:04
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\78.子集.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {

    List<List<Integer>> ret = new ArrayList<>();
    ArrayList<Integer> in = new ArrayList<>();
    /**
     * *递归解法， 每个位置 在或不在
     * @param cur
     * @param nums
     */
    public void dfs(int cur, int[] nums){
        if(cur == nums.length){
            ret.add(new ArrayList<>(in));
            return;
        }
        in.add(nums[cur]);
        dfs(cur + 1, nums);
        in.remove(in.size() - 1);
        dfs(cur + 1, nums);
    }
    public List<List<Integer>> subsetsRecursion(int[] nums) {
        dfs(0, nums);
        return ret;
    }
    /**
     * *迭代法实现子集枚举
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums){
        int count = (1 << nums.length);
        for (int mask = 0; mask < count; mask++) {
            for (int i = 0; i < nums.length; i++) {
                if((mask & (1 << i)) != 0){
                    in.add(nums[i]);
                }
            }
            ret.add(new ArrayList<>(in));
            in.clear();
        }
        return ret;
    }
}
// @lc code=end

