class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;
        for(int i = 0; i < stations.length; i++){
            int front = stations[i] - w;
            if(front > start){
                int count = front - start;
                answer += count/((2*w)+1);
                if(count%((2*w)+1) != 0)
                    answer += 1;
            }
            start = stations[i] + w + 1;

            if(i == stations.length-1){                
                int last = stations[i] + w;
                int count = n-last;
                if(count > 0 ){
                    answer += count/((2*w)+1);
                    if(count % ((2*w)+1) != 0)
                        answer += 1;
                }
            }
            
        }
        
        return answer;
    }
}