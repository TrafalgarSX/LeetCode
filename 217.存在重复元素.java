import java.util.HashSet;

/*
 * @Author: guo yawen
 * @Date: 2021-04-26 13:29:29
 * @LastEditTime: 2021-04-26 14:13:51
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\217.存在重复元素.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    /**
     * * HashSet method 
     * @param nums
     * @return
     */
    public boolean containsDuplicateSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
    /**
     * * 排序做法
     */
    public boolean containsDuplicate(int[] nums) {

    }
}
// @lc code=end

