import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-04-14 00:46:28
 * @LastEditTime: 2021-04-14 21:40:58
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\15.三数之和.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    //  ! 思路
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 3){
            return list;
        }
        Arrays.sort(nums);
        int left, right;
        //!暴力解法三层循环，优化方法为 排序加双指针。可以减少一层循环。
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                break;
            }
            //*去除重复解
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] + nums[i] == 0){
                    ArrayList<Integer> in = new ArrayList<>();
                    in.add(nums[i]);in.add(nums[left]);in.add(nums[right]);
                    list.add(in);
                    //*去除重复解
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--; 
                    left++;
                    right--;
                }else if(nums[left] + nums[right] + nums[i] > 0 ){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return list;
    }
}
// @lc code=end

