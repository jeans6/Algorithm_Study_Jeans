package HHS;

import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    static int[] nums;
    static int tarNum;
    
    public int solution(int[] numbers, int target) throws IOException{
        nums = new int[numbers.length];
        for(int i=0; i < numbers.length; i++){
            nums[i] = numbers[i];
        }
        tarNum = target;
        dfs(0,0);        
        
        return answer;
    }
    // +와 - 두 경우 다 넣어서 dfs 돌리기
    public static void dfs(int num, int sum){
        // numbers를 다 돌았을 때 계산값이 타겟넘버와 같을 경우 answer 올리기
        if(num == nums.length && sum == tarNum){
            answer++;
        }else if(num < nums.length){
            dfs(num+1, sum+nums[num]);
            dfs(num+1, sum-nums[num]);
        }
    }
    
}
