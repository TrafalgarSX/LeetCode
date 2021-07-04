import java.util.HashMap;

/*
 * @author: guo yawen
 * @Date: 2021-07-04 15:05:51
 * @lastEditTime: do not edit
 * @lastEditors: guo yawen
 * @description: 
 * @FilePath: \LeetCoded:\javawork\leetCode\205.同构字符串.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    /**
     * *同构
     */
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        int count = s.length();
        for (int i = 0; i < count; i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if( (sMap.containsKey(x) && sMap.get(x) != y) || (tMap.containsKey(y) && tMap.get(y) != x) ){
                return false;
            }
            sMap.put(x, y);
            tMap.put(y, x);
        }
        return true;
    }
}
// @lc code=end

