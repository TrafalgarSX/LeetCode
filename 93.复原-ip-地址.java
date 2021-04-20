import java.util.ArrayList;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-04-20 11:07:12
 * @LastEditTime: 2021-04-20 13:43:36
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\93.复原-ip-地址.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {
    /**
     * *1、字符串的长度小于4 或者大于12，一定不能拼凑除合法的Ip
     * *2、每一个部分可以选择截取的长度为： 截取 1位、2位、3位。
     * *3、根据截取出来的字符串判断是否是合理的ip段，可以转换成int类型和255比较。
     * *具体实现可以从前往后截取，这样需要一个 栈（path)记录树上结点的路径，最后将栈中内容转换成Ip
     * *也可以从后往前截取，这样可以在一个 StringBuilder上修改，最后判断是否符合。
     * @param ipPart
     * @return
     */
    public boolean valid(String ipPart){
        if(ipPart.length() == 1){
            return true;
        }
        if(ipPart.charAt(0) == '0'){
            return false;
        }
        if(Integer.parseInt(ipPart) > 255){
            return false;
        }
        return true;
    }
    public void backTrack(StringBuilder ip, int index, int part, List<String> ret){
        if(part == 4){
            if(valid(ip.substring(0, index))){
                ret.add(ip.toString());
            }
            return;
        }
        for (int i = 1; i < 4; i++) {
            if(index - i > 0 && valid(ip.substring(index - i , index))){
                ip.insert(index - i, '.');
                backTrack(ip, index - i, part + 1, ret);
                ip.deleteCharAt(index - i);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        if(s.length() > 12 || s.length() < 4){
            return ret;
        }
        backTrack(new StringBuilder(s), s.length(), 1, ret);
        return ret;
    }
}
// @lc code=end

