/*
 * @Author: guo yawen
 * @Date: 2021-05-28 17:09:21
 * @LastEditTime: 2021-05-28 22:04:52
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\189.旋转数组.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    /**
     * *两个整数的最大公约数等于其中较小的数和两数相除余数的最大公约数。
     * @param n
     * @param k
     * @return
     */
    public int gcd(int x, int y){
        int temp;
        while(y > 0){
            temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(n, k);
        int current, temp, prev;
        for(int i = 0; i < count; i++){
            current = i;
            prev = nums[i];
            do{
               current = (current + k) % n;
               temp = nums[current] ;
               nums[current] = prev;
               prev = temp;
            }while(current != i);
        }
    }
    /**
     * *三次旋转的方法
     */
    public void rotateThree(int[] nums, int k) {
        int realK = k % nums.length;
        int left = 0, right = nums.length - realK - 1;
        int temp;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        left = nums.length - realK;
        right = nums.length - 1;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        left = 0;
        right = nums.length - 1;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
// @lc code=end

