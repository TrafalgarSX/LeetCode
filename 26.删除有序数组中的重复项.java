import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-04-08 10:28:03
 * @LastEditTime: 2021-04-08 11:24:06
 * @LastEditors: guo yawen
 * @Description: 技巧十分巧妙，注意掌握。
 * @FilePath: \LeetCode\26.删除有序数组中的重复项.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    //更好的双指针，不需要额外的空间。
    //就地复制
    public int betterRemoveDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            //这里不等判断，将相等的 j 增加到 不相等的 j。
            //然后复制给 自增的 i ，接着进行判断。
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    //双指针，将相同的数跳过，迭代双指针。
    public int removeDuplicates(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        int idx = 0;
        //结尾两种情况判断：
        //1.结尾两个数不相同，那么最后一个数会进入循环，然后判断失败，复制成功
        //2.结尾多个数相同，那么循环直到 j 越界，然后 i 跳出。
        for (int i = 0; i  < numsCopy.length; ) {
            int j = i + 1;
            while( j < numsCopy.length && numsCopy[i] == numsCopy[j]){
                j++;
            }
            nums[idx++] = numsCopy[i];
            i = j;
        }
        
        return idx;
    }
}
// @lc code=end

