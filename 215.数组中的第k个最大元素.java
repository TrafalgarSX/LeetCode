import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-04-11 17:52:31
 * @LastEditTime: 2021-04-14 00:36:50
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\215.数组中的第k个最大元素.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int quickSort(int[] nums, int left, int right, int k){
        
        return 0;
    }
    public void maxHeapify(int[] nums, int i, int size){
        //非递归形式
        while (true) {
            int left = ( i << 1) + 1;
            int right = (i << 1) + 2;    
            int largest = i;
            if(left < size && nums[left] > nums[i]) {
                largest = left;
            }           
            if(right < size && nums[right] > nums[largest]) {
                largest = right;
            }
            if(largest != i){
                swap(nums, largest, i);
                i = largest;
            }else{
                break;
            }
        }
    }
    /**
     * * 建立一个 最大堆，每个叶子结点都可看作包含一个元素的堆
     * * 对每个非叶子结点进行堆的调整，若数组从 1 开始计数，
     * * 从nums.length /2 的向下取值 + 1是叶子结点。
     * * 若数组从 0 开始计数, nums.length /2 是叶子结点
     * @param nums
     */
    public void buildMaxHead(int[] nums){
        //! 这里因为叶子节点不影响，所以从 nums.length / 2开始
        for (int i = nums.length/2; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1){
            return nums[0];
        }
        // *建立一个最大堆
        buildMaxHead(nums);
        int size = nums.length;
        //* 堆排序的算法
        for (int i = 0; i < k ; i++) {
            // * 将 最大堆中 最大的结点和最后一个叶子结点交换。
            swap(nums, 0, --size );
            //* 调整0-(size-1)的堆。
            maxHeapify(nums, 0, size);
        }
        int index = nums.length - k;
        System.out.println(Arrays.toString(nums));
        return nums[index];
    }
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end

