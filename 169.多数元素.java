import java.util.Arrays;


/*
 * @Author: guo yawen
 * @Date: 2021-05-09 18:13:58
 * @LastEditTime: 2021-05-09 21:33:07
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\169.多数元素.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    /**
     * * search mode of the array 
     */

    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == candidate){
                ++count;
            }else if( --count == 0){
                count = 1;
                candidate = nums[i];
            }

        }
        
        return candidate;
    }
    /**
     * *The final result element is at the length/2 coordinate of the array
     * @param nums
     * @return
     */
    public int majorityElementSort(int[] nums) {
        int ret = 0;
        Arrays.sort(nums);
        ret = nums[nums.length/2];
        return ret;
    }
}
// @lc code=end

