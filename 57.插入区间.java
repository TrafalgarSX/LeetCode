import java.util.ArrayList;
import java.util.Arrays;

/*
 * @Author: guo yawen
 * @Date: 2021-06-08 18:00:55
 * @LastEditTime: 2021-06-08 23:51:56
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\57.插入区间.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    /**
     * *和56题一样的解法，只不过先把newInterval加入数组，然后再排序，最后进行合并
     * *思路简单，但是时间花的优点多了。有更好的方法。
     */
    public int[][] insertMine(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            merged.add(intervals[i]);
        }
        merged.add(newInterval);
        intervals = merged.toArray(new int[merged.size()][]);
        Arrays.sort(intervals, (int[] first, int[] second) ->{
            return first[0] - second[0];
        });
        merged.clear();

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

    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> merged = new ArrayList<>();
        boolean placed = false;
        int left = newInterval[0];
        int right = newInterval[1];
        for (int[] interval: intervals) {
            if(interval[0] > right){
                if(!placed){
                    left = interval[0];
                    right = interval[1];
                    placed = true;
                }
                merged.add(new int[]{left, right});
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end

