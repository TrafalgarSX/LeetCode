import java.util.ArrayList;
import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-06-02 13:14:40
 * @LastEditTime: 2021-06-02 15:17:02
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\56.合并区间.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    /**
     * *自己的方法
     * @param intervals
     * @return
     */
    public int[][] mergeMine(int[][] intervals) {
        Arrays.sort(intervals,(int[] t0, int[] t1) ->
                                t0[0] - t1[0]);
        ArrayList<int[]> array = new ArrayList<>();
        int left, right; 
        left = intervals[0][0];
        right = intervals[0][1];
        for (int i = 0; i < intervals.length - 1; i++) {
            if(right >= intervals[i + 1][1]){
                continue;
            }if(right >= intervals[i + 1][0]){
                right = intervals[i + 1][1];
                continue;
            }
            else{
                array.add(new int[]{left, right});
                left = intervals[i + 1][0];
                right = intervals[i + 1][1];
            }
        }
        array.add(new int[]{left, right});
        // int[][] ret = new int[array.size()][2];
        // for (int i = 0; i < ret.length; i++) {
        //     ret[i] = array.get(i);
        // }
        /**
         * *列表转数组，这是什么情况？？？
         */
        return array.toArray(new int[array.size()][]);

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(int[] t0, int[] t1) ->
                                t0[0] - t1[0]);
        ArrayList<int[]> merged = new ArrayList<>();
        int left, right;
        for (int i = 0; i < intervals.length; i++) {
            left = intervals[i][0];
            right = intervals[i][1];
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < left){
                merged.add(new int[]{left, right});
            }else{
                merged.get(merged.size() - 1)[1] = Math.max(right, merged.get(merged.size() - 1)[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end

