/*
 * @Author: your name
 * @Date: 2021-03-30 00:00:59
 * @LastEditTime: 2021-03-30 00:43:30
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\1.两数之和.java
 */
/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
import java.util.*;
class Solution {
    //brutal force 
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
        }
        return ret;
    }

    public int[] twoSum_hash(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
// @lc code=end

