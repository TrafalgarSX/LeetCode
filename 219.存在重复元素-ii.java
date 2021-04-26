import java.util.HashSet;

/*
 * @Author: guo yawen
 * @Date: 2021-04-26 14:20:24
 * @LastEditTime: 2021-04-26 15:09:30
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\219.存在重复元素-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    /**
     * *线性搜索，超出时间限制
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicateBrutal(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - k, 0); j < nums.length; j++) {
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
    /**
     * * HashSet method 
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
// @lc code=end

