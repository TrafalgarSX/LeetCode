/*
 * @author: guo yawen
 * @Date: 2021-06-13 19:41:23
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\167.两数之和-ii-输入有序数组.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] ans = new int[2];
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] < target){
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end

