import java.util.ArrayList;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-04-13 15:57:57
 * @LastEditTime: 2021-04-13 16:28:03
 * @LastEditors: guo yawen
 * @Description:    
 * @FilePath: \LeetCode\119.杨辉三角-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> ret = new ArrayList<>(rowIndex + 1);
        ret.add(1);
        if(rowIndex == 0){
            return ret;
        }
        ret.add(1);
        if(rowIndex == 1){
            return ret;
        }
        
        int temp = 0;
        /**
         * *从前往后加需要 一个变量存储被覆盖的 值
         * *可以改成从后往前加。
         */
        for (int i = 2; i < rowIndex + 1; i++) {
            temp = ret.get(0);
            int len = ret.size();
            for (int j = 0; j + 1< len; j++) {
                int sum = temp + ret.get(j+1);
                temp = ret.get(j + 1);
                ret.set(j+1, sum);;
            }
            ret.add(1);
        }
        return ret;

    }
}
// @lc code=end

