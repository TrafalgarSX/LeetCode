/*
 * @Author: guo yawen
 * @Date: 2021-04-10 23:56:31
 * @LastEditTime: 2021-04-13 12:33:52
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\81.搜索旋转排序数组-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 */

// @lc code=start
class Solution {
    /**
     * !数组可以有重复
     * *本题和33题都是查找target，我们直到在有序数组中（不管是否重复）都可以得到结果
     * *如果找到，在循环中就可以返回，如果找不到，即left > right ,则跳出循环，返回-1
     * !这两题本质是数组局部有序，我们每找到一个mid,他的一侧总是局部有序的。
     * *所以我们先在局部有序的数组中找target，如果target不在局部有序的范围内，
     * *则到到另一半数组中（可能有序，可能无序）再找局部有序的区间，进行查找。
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if( nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return nums[0] == target ;
        }
        int left = 0, right = nums.length - 1;
        while( left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true;
            }
            // ! 与33题不同之处。
            // ! 当nums[left] <= nums[mid] 的时候 left-mid不一定有序，因为数组有重复
            // !比如 232222 这种数组，前面又判断过 nums[mid] != target.
            // ! 所以我们要将 左右指针缩小直到 nums[left] <= nums[mid] 这个判断能够确定某一侧有序。
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                ++left;
                --right;
            }
            //* 如果左侧有序
            else if( nums[left] <= nums[mid] ){
                if( nums[mid] > target && nums[left] <= target ){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{ //*如果左侧无序，右侧则一定有序[mid,right].
                
                if(nums[mid] < target && nums[right] >= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
// @lc code=end

