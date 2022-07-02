import java.util.*;
import java.io.*;

class Solution {
    static int count;
    static int len;
    
    public int solution(int n, int[] cores) {
        int answer = 0;
        int min = 0;
        int max = cores[0] * n;
                
        int time = 0;
        int amount = 0;
       
        len = cores.length;
        
        while(min <= max){
            int mid = (min + max) / 2;
            
            Core(mid, cores);
            
            if(count >= n){//처리한 것보다 n이 더 크면 맥스 줄여
                max = mid - 1;
                time = mid;
                amount = count; 
            }else
                min = mid + 1;  
        }
        
        amount -= n;
        for(int i = len-1; i >= 0; i--){
            if(time % cores[i] == 0){
                if(amount == 0)
                    return i+1;

                amount--;
            }
        }
        
        return answer;
    }
    
    private static void Core(int mid, int[] cores){
        
        if(mid == 0){
            count = len;
            return;
        }
        
        count = len;
        for(int i = 0; i < len; i++)
            count += (mid / cores[i]);
        
    }
    
}
