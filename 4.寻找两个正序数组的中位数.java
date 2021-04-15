import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-03-30 13:25:36
 * @LastEditTime: 2021-04-15 18:11:02
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\4.寻找两个正序数组的中位数.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {

    //*暴力法，先归并，然后计算中位数
    public double findMedianSortedArraysBrutal(int[] nums1, int[] nums2) {
        int[] array = new int[nums1.length + nums2.length];
        int idx1 = 0;
        int idx2 = 0;
        int i = 0;
        while(idx1 < nums1.length && idx2 < nums2.length){
            if(nums1[idx1] <= nums2[idx2]){
                array[i] = nums1[idx1];
                idx1++;
            }else{
                array[i] = nums2[idx2];
                idx2++;
            }
            i++;
        }
        while(idx1 < nums1.length){
            array[i++] = nums1[idx1++];
        }
        while(idx2 < nums2.length){
            array[i++] = nums2[idx2++];
        }
        System.out.println(Arrays.toString(array));
        double ret = 0;
        int len = nums1.length + nums2.length;
        if(len % 2 == 0){
            ret = array[len/2] + array[len/2-1];
            ret /= 2;
        }else{
            ret = array[len/2];
        }
        return ret;
    }

    /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * 这里的 "/" 表示整除
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */
    public double findKMin(int[] nums1, int[] nums2, int k){
        int left1 = 0, left2 = 0;   
        while (true) {
            if(left1 == nums1.length){
                return nums2[left2 + k -1];
            }
            if (left2 == nums2.length){
                return nums1[left1 + k -1];
            }
            if(k == 1){
                return Math.min(nums1[left1], nums2[left2]);
            }
            int half = k / 2;
            //!由于存在 left + half 超过了数组长度的可能。
            //! 所以当超过时，以数组长度 - 1 作为下标,去进行比较。（选取数组最后一个数）
            //! 如果超过数组长度 - 1 不能够跳过，因为 有可能跳过中位数。
            int tempLeft1 = Math.min(left1 + half, nums1.length) - 1;
            int tempLeft2 = Math.min(left2 + half, nums2.length) - 1;
            
            if(nums1[tempLeft1] <= nums2[tempLeft2]){
                k -= (tempLeft1 - left1 + 1);
                left1 = ++tempLeft1; // * half - 1 + 1;
            }else{
                k -= (tempLeft2 - left2 + 1);
                left2 = ++tempLeft2;
            }
        }
        

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        double median;
        if(len % 2 == 1){
            int mid = len / 2;
            median = findKMin(nums1, nums2, mid + 1);
        }else{
            int midLeft = len / 2;
            int midRight = len / 2 - 1;
            median = (findKMin(nums1, nums2, midLeft + 1) + findKMin(nums1, nums2, midRight + 1)) / 2.0;
        }
        return median;
    }
}
// @lc code=end

