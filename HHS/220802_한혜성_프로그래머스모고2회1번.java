import java.util.*;

class Solution {
    static int answer;
    static int N;
    static int [] n;

    public int solution(int[] number) {
        n = number;    
        N = number.length;
        //Combination으로 3개씩 한다음에 번호 더했을 때 0나오면 answer 올리기
        Comb(0, 0, new int[3]);        


        return answer;
    }
    private static void Comb(int start, int cnt, int [] nums){
        if(cnt == 3){
            int sum = 0;
            for(int i = 0; i < 3; i++){
                sum += n[nums[i]];
            }
            if(sum == 0)
                answer++;
            return;
        }
        for(int i = start; i < N; i++){
            nums[cnt] = i;
            Comb(i+1, cnt+1, nums);
        }

    }
}