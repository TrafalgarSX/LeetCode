import java.util.ArrayList;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-04-13 15:45:39
 * @LastEditTime: 2021-04-13 15:57:17
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\118.杨辉三角.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        in.add(1);
        list.add(in);
        if(numRows == 1){
            return list;
        }
        in = new ArrayList<>();
        in.add(1);in.add(1);
        list.add(in);
        if(numRows == 2){
            return list;
        }
        for (int i = 2; i < numRows; i++) {
            ArrayList<Integer> add= new ArrayList<>();
            add.add(1);
            int len = list.get(i-1).size();
            for (int j = 0; j + 1< len; j++) {
                int sum = list.get(i-1).get(j) + list.get(i-1).get(j+1);
                add.add(sum);
            }
            add.add(1);
            list.add(add);
        }
        return list;
    }
}
// @lc code=end

