import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Author: guo yawen
 * @Date: 2021-04-18 17:34:57
 * @LastEditTime: 2021-04-18 17:47:35
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\17.电话号码的字母组合.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    Map<Character,String> phoneMap = new HashMap<>(){
        {
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }
    };
    /**
     * *回溯法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if(digits.length() == 0){
            return ret;
        }
        backTrack(digits, new StringBuilder(), 0, ret);
        return ret;
    }
    public void backTrack(String digits, StringBuilder combination, int index, List<String> ret){
        if(index == digits.length()){
            ret.add(combination.toString());
            return;
        }
        char c = digits.charAt(index);
        String temp = phoneMap.get(c);
        for (int i = 0; i < temp.length(); i++) {
            combination.append(temp.charAt(i));
            backTrack(digits, combination, index + 1, ret);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
// @lc code=end

