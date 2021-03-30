import java.util.HashSet;

/*
 * @Author: your name
 * @Date: 2021-03-30 00:56:50
 * @LastEditTime: 2021-03-30 13:24:46
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: \LeetCode\3.无重复字符的最长子串.java
 */
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    //滑动窗口
    //自己写的
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null){
            return 0;
        }
        int left = 0,right = left + 1;
        int max = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while(right < s.length()){
            if(set.contains(s.charAt(right))){
                left++;
                right = left + 1;
                set.clear();

                set.add(s.charAt(left));
            }else{
                set.add(s.charAt(right));
                max = Math.max(max,set.size());
                right++;
            }
        }
        return max;
    }
    //Better method
    public int lengthOfLongestSubstringAnswer(String s) {
        if(s.length() == 0 || s == null){
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        //right = -1表示 还没有开始滑动；
        int max = 0 ,right = -1 ;
        for (int i = 0; i < s.length(); i++) {
            if( i != 0){
                set.remove(s.charAt(i-1));
            }
            while(right + 1< s.length() && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                right++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
// @lc code=end

