import java.util.ArrayList;
import java.util.List;

/*
 * @Author: guo yawen
 * @Date: 2021-05-09 19:54:31
 * @LastEditTime: 2021-05-09 21:31:04
 * @LastEditors: guo yawen
 * @Description: 
 * @FilePath: \LeetCode\229.求众数-ii.java
 * TrafalgarSX
 */
/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 求众数 II
 */

// @lc code=start
class Solution {
    /**
     * * vote method
     * *If current element equals to the value of any candidate, the candidate get a vote; (one voter can only vote for one candidate)
     * *If the vote of any candidate is 0, then current element is set as a new candidate and he can get a vote immediately; (A voter can also be elected)
     * *Otherwise, current element vote against all candidates and all candidates lose a vote.
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums.length == 0){
            return ret;
        }
        int candidateOne, candidateTow, countOne, countTwo;
        candidateOne = Integer.MAX_VALUE;
        candidateTow = Integer.MAX_VALUE;
        countOne = 0;
        countTwo = 0;
        for (int num : nums) {
            if(num == candidateOne){
                ++countOne;
            }else if(num == candidateTow){
                ++countTwo;
            }else if(countOne == 0){
                candidateOne = num;
                countOne = 1;
            }else if(countTwo == 0){
                candidateTow = num;
                countTwo = 1;
            }else{
                --countOne;
                --countTwo;
            }
        }
        //* After election, we need to count the vote again.
        countOne = 0;
        countTwo = 0;
        for (int num : nums) {
            if(num == candidateOne){
                ++countOne;
            }else if(num == candidateTow){
                ++countTwo;
            }
        }
        if(countOne > nums.length / 3){
            ret.add(candidateOne);
        }
        if(countTwo > nums.length / 3){
            ret.add(candidateTow);
        }
        return ret;
    }
}
// @lc code=end

