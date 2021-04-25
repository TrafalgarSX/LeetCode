import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-04-25 18:42:26
 * @LastEditTime: 2021-04-25 23:25:41
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\31.下一个排列.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    /**
     * *下一个排列
     * * 先从后往前找到逆序的数，
     * * 然后从后往前找到比 逆序 大的数
     * * 最后将后面的数变成升序
     * !本质上是找到比上一个数大的书中的最小数。
     * !leetcode美站简答比较清晰。
     */
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int i = nums.length - 1;
        while(i - 1 >= 0 && nums[i - 1] >= nums[i]){
            i--;
        }
        if( i - 1 >= 0){
            int j = nums.length - 1;
            while(nums[j] <= nums[i - 1]){
                j--;
            }
            swap(nums, i - 1, j);
        }
        Arrays.sort(nums, i, nums.length);
    }
    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
// @lc code=end

