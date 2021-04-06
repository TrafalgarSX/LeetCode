/*
 * @Author: guo yawen
 * @Date: 2021-03-30 14:50:52
 * @LastEditTime: 2021-04-05 00:49:29
 * @LastEditors: guo yawen
 * @FilePath: \LeetCode\6.z-字形变换.java
 */
/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
import java.util.*;
class Solution {
    //按行排序  用填矩阵的方法 来模拟整个过程
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        List<StringBuilder> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        //决定有几行，如果字符串的长度 比行数还小，就字符串的长度即可
        for (int i = 0; i < Math.min(numRows,s.length()); i++) {
            list.add(new StringBuilder());
        }
        int curRow = 0;
        //决定方向 向上还是向下
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows-1){
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder);
        }
        return result.toString();
    }
    //按行访问
    /**
     * 首先访问 行 0 中的所有字符，接着访问 行 1，然后 行 2，依此类推...
    对于所有整数 k，

    行 0 中的字符位于索引 k (2⋅numRows−2) 处; numRows - 1 + numRows - 2 + 1;
    行 numRows-1 中的字符位于索引 k (2⋅numRows−2)+numRows−1 处; 
    内部的 行 i 中的字符位于索引 k (2⋅numRows−2)+i 以及 (k+1)(2⋅numRows−2)−i 处

    整体上的规律就是： k (2⋅numRows−2) + i (i是第几行的参数)
     * @param s
     * @param numRows
     * @return
     */
    public String convertByLine(String s, int numRows) {
        if(numRows == 1) return s;
        
        StringBuilder ret = new StringBuilder();
        int len =  2 * numRows -2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j+= len) {
                ret.append(s.charAt(j + i));
                if( i != 0 && i != numRows-1 && j - i + len < s.length()){
                    ret.append(s.charAt(j - i + len));
                }
            }
        }
        return ret.toString();
    }
}
// @lc code=end

