/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public int removeElement(int[] nums, int val) {
       int size = nums.length; 
       int i = 0;
       while(i < size){
           while( i < size && nums[i] == val){
            //*交换可以，但没必要，而且空间复杂度高了。
            //    swap(nums, i, --size);
            //*是删除 = val 的值的。
            nums[i] = nums[--size];
           }
           i++;
       }
       return size;
    }
}
// @lc code=end

