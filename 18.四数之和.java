import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-04-16 23:10:54
 * @LastEditTime: 2021-04-17 00:28:24
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\18.四数之和.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 4){
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if( i > 0 && nums[i - 1] == nums[i]){
                continue;
            }
            //!有了这四个 就要保证不能数组越界
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target){
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if( j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right){
                    ArrayList<Integer> in = new ArrayList<>();
                    if(nums[i] + nums[j] + nums[left] + nums[right] == target){
                        in.add(nums[i]);in.add(nums[j]);in.add(nums[left]);in.add(nums[right]);
                        list.add(in);
                        while(left < right && nums[left] == nums[left+1]) left++;
                        left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    }
                    else if(nums[i] + nums[j] + nums[left] + nums[right] < target ){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
// @lc code=end

