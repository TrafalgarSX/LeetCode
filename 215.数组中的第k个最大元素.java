import java.util.Arrays;
import java.util.Random;

/*
 * @Author: guo yawen
 * @Date: 2021-04-11 17:52:31
 * @LastEditTime: 2021-04-14 12:33:14
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
    /*==================heapSort method===================*/
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
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
    public int findKthLargestHeapSort(int[] nums, int k) {
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
    /*==================heapSort method===================*/
    

    /*==================quickSort method===================*/
    //*一种partition算法
    public int partition(int[] nums,int left, int right){
        int pivot = nums[left];
        while(left < right){
            while(left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
    //*第二种partition算法
    public int partition2(int[] nums, int left, int right){
        int pivot = nums[right];
        int lefti = left - 1;
        while(left < right){
            if(nums[left] < pivot){
                ++lefti;
                swap(nums, lefti, left);
            }
            left++;
        }
        swap(nums, ++lefti, right);
        return lefti;
    }
    //*第三种partition算法，随机化版本 效率最高。时间击败 91%,空间击败 99.74%
    //!算法导论证明。
    public int randomizedPartition(int[] nums, int left, int right){
        Random random = new Random();
        int i = random.nextInt((right-left)+1)+left;
        swap(nums, i, right);
        return partition2(nums, left, right);

    }
    public int quickSort(int[] nums, int left, int right, int k){
            int mid = randomizedPartition(nums, left, right);
            if(mid == k){
                return nums[k];
            }else if(mid > k){
                return quickSort(nums, left, mid-1, k);
            }else {
                return quickSort(nums, mid+1, right, k);
            }
    }
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        return quickSort(nums, 0, nums.length -1, index);
    }

    /*==================quickSort method===================*/
}
// @lc code=end

