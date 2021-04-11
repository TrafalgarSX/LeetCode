import java.util.HashSet;

/*
 * @Author: guo yawen
 * @Date: 2021-04-10 23:57:13
 * @LastEditTime: 2021-04-11 17:44:38
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\80.删除排序数组中的重复项-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
 
    /**
     * 通用方法，一大特点： 数组是有序的 和 双指针
     * 有滑动窗口思想,维护一个 长度为 k 的滑动窗口
     * 如果允许排序数组中有 k 个重复项，那么 快指针和
     * 慢指针(滑动窗口中的第一个) 如果相等说明窗口中
     * 的重复项已有 k 个，所以该元素不能插入；如果不相等，
     * 说明窗口中重复项不足 k 个，该元素可以插入。
     */
    public int removeDuplicatesOfficial(int[] nums) {
        return process(nums, 2);
    }
    public int process(int[] nums, int k){
        int u = 0;
        for (int num : nums) {
            if(u < k || nums[u-k] != num){
                nums[u++] = num;
            }
        }
        return u;
    }
    public int removeDuplicatesBetter(int[] nums) {
       int len = nums.length;
       int i = 0, j = i + 1;
       boolean flag = true; 
       for (; j < len; j++) {
           if(nums[i] != nums[j]){
               nums[++i] = nums[j];
               flag = true;
           }else if(flag) {
               nums[++i] = nums[j];
               flag = false;
           }
           
       }
       return i+1;
    }
    //哈希方法。
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j = i + 1;
        for (; j < len; j++) {
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }else if(nums[i] == nums[j]){
                if(!set.contains(nums[i])){
                    nums[++i] = nums[j];
                    set.add(nums[i]);
                }
            }
        }
        return i + 1;
    }
}
// @lc code=end

