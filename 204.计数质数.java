import java.util.Arrays;

/*
 * @author: guo yawen
 * @Date: 2021-07-03 23:37:30
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\204.计数质数.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public boolean isPrime(int n){
        if( n < 2){
            return false;
        }
        for (int i = 2; i * i <= n ;i++) {
            if(n % i == 0){
                return false;
            }
        }    
        return true;
    }
    /**
     * * 时间超了
     * @param n
     * @return
     */
    public int countPrimesMine(int n) {
        int ans = 0;

        while( (n - 1)> 1 ){
            if(isPrime(n - 1)){
                ans++;         
            }
            n--;
        }
        return ans;
    }
    /**
     * *称为厄拉多塞筛法，简称埃氏筛
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

