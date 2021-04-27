import java.util.HashSet;

/*
 * @Author: guo yawen
 * @Date: 2021-04-27 16:25:35
 * @LastEditTime: 2021-04-27 17:43:27
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\202.快乐数.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public int happy(int n){
        int ret = 0;
        while(n != 0){
            ret += Math.pow(n%10, 2);
            n = n / 10;
        }
        return ret;
    }
    /**
     * *hashSet method
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        if(n == 1) return true;
        set.add(n);
        do{
            n = happy(n);
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }while(n != 1);
        return true;
    }
    /**
     * *slow fast pointer
     * @param n
     * @return
     */
    public boolean isHappyList(int n){
        int slow = n;
        int fast = happy(n);
        while(fast != 1 && slow != fast){
            slow = happy(slow);
            fast = happy(happy(fast));
        }
        return fast == 1;
    }
}
// @lc code=end

