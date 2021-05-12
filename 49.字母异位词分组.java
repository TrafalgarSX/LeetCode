import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: guo yawen
 * @Date: 2021-05-12 21:19:23
 * @LastEditTime: 2021-05-12 22:10:17
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\49.字母异位词分组.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] array = string.toCharArray();
            Arrays.sort(array);
            String temp = new String(array);
            List<String> list = map.getOrDefault(temp, new ArrayList<String>());
            list.add(string);
            map.put(temp, list);
        }
        return  new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

