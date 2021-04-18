import java.util.ArrayList;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-04-09 16:25:53
 * @LastEditTime: 2021-04-18 17:23:50
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\22.括号生成.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    /**
     * *验证生成的括号是否有效。
     * *用一个变量保存 左括号的数量。
     * * 1、如果在匹配过程中，左括号数量小于0则不匹配
     * * 2、如果最后，左括号数量不为0 则不匹配。
     */
    public boolean valid(char[] quote){
        boolean ret = false;
        int leftQuoteCount = 0;
        for (int i = 0; i < quote.length; i++) {
            if (quote[i] == '(') {
                leftQuoteCount++;
            }else{
                leftQuoteCount--;
                
                if (leftQuoteCount <0) {
                    break;
                }
            }
        }
        if(leftQuoteCount == 0){
            ret = true;
        }
        return ret;
    }
    /**
     * *利用递归生成所有的序列
     * *长度为 n 的括号序列就是在长度为 n - 1的括号序列上增加一个'(' ')'
     * @param quote
     * @param pos
     * @param list
     */
    public void generateAll(char[] quote, int pos, List<String> list){
        if(pos == quote.length){
            if(valid(quote)){
                list.add(new String(quote));
            }
        }else{
            quote[pos] = '(';
            generateAll(quote, pos + 1, list);
            quote[pos] = ')';
            generateAll(quote, pos + 1, list);
        }

    }
    //*  暴力法
    public List<String> generateParenthesisBrutal(int n) {
        List<String> ret = new ArrayList<>();
        generateAll(new char[2*n], 0, ret);       
        return ret;
    }
    public void backTrack(StringBuilder quote, int left, int right, int max, List<String> ret){
        if(left == max && right == max){
            ret.add(quote.toString());
            return;
        }
        if(left < max){
            quote.append('(');
            backTrack(quote, left + 1, right, max, ret);
            quote.deleteCharAt(quote.length() - 1);
        }
        if(right < left){
            quote.append(')');
            backTrack(quote, left, right + 1, max, ret);
            quote.deleteCharAt(quote.length() - 1);
        }
    }
    /**
     * *回溯法
     * *我们可以只在序列仍然保持有效时才添加 '(' or ')'
     * *通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点
     * *1、如果左括号数量不大于 n，我们可以放一个左括号。
     * *2、如果右括号数量小于左括号的数量，我们可以放一个右括号。
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        backTrack(new StringBuilder(), 0, 0, n, ret);
        return ret;
    }
}
// @lc code=end

