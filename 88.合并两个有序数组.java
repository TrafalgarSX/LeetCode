import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-04-07 22:36:37
 * @LastEditTime: 2021-04-07 23:00:47
 * @LastEditors: guo yawen
 * @Description: 华为面试题 两种方法 归并，和 数组从后往前
 * @FilePath: \LeetCode\88.合并两个有序数组.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    //从后往前归并
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]){
                nums1[m+n-1] = nums1[i];
                m--;
                i--;
            }else{
                nums1[m+n-1] = nums2[j];
                n--;
                j--;
            }
        }
        while(j >= 0){
            nums1[m+n-1] = nums2[j];
            n--;
            j--;
        }
    }
    //从前往后归并
    public void merge2(int[] nums1, int m, int[] nums2, int n){
        int[] nums1Copy = Arrays.copyOfRange(nums1, 0, m);
        int i = 0, j = 0;
        int idx = 0;
        while(i < m && j < n){
            if(nums1Copy[i] < nums2[j]){
                nums1[idx] = nums1Copy[i];
                i++;
            }else{
                nums1[idx] = nums2[j];
                j++;
            }
            idx++;
        }
        while(i < m){
                nums1[idx] = nums1Copy[i];
                idx++;
                i++;
        }
        while(j < n){
                nums1[idx] = nums2[j];
                idx++;
                j++;
        }
    }
}
// @lc code=end

