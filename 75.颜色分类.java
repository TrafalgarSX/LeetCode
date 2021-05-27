/*

 * @Date: 2021-05-26 20:22:38
 * @LastEditTime: 2021-05-27 18:03:58

/* 
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    /**
     * *双指针，使用指针left交换 0,right交换 2 
     * *case1: 如果nums[i] == 0 ,那么与nums[left] 交换,left向后移动一个位置
     * *case2: 如果nums[i] == 2, 那么与nums[right]交换，right向前移动一个位置
     * * 如果nums[i] 仍然等于2，接着与nums[right]交换，如果nums[i] == 1, 按第一种情况处理
     * * 如果nums[i] == 1, 不需要任何操作
     * @param nums
     */
    public void sortColorsDou(int[] nums) {
        int left = 0, right = nums.length - 1;
        int temp;
        for (int i = 0; i <= right; i++) {
            while(i <= right && nums[i] == 2){
                temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
            if(nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }          
        }
    }
    /**
     * *两遍扫描
     */
    public void sortColors(int[] nums) {
        int ptr = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if(nums[i] == 1){
                temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ptr++;
            }
        }
    }
}
// @lc code=end

