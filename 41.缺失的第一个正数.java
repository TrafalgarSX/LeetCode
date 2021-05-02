import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-04-30 22:51:29
 * @LastEditTime: 2021-05-02 23:54:15
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\41.缺失的第一个正数.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            /**
             * *前面的会修改后面的（变为负），
             * *所以用后面的判断时要进行求绝对值。
             */
            int num = Math.abs(nums[i]);
            if(num >0 && num < n + 1){
                //*这里也要加绝对值是为了防止 重复元素出现
                //*保证 在范围内的为 负数。（否则第一次为 负，第二次为正）
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n + 1;
    }
}
// @lc code=end

