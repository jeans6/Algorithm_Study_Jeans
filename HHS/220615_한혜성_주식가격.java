package HHS;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        //이중포문 돌려서 해당 값보다 작은 값 나오면 j-i값 넣기
        for(int i = 0; i < prices.length-1; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[i] > prices[j]){
                    answer[i] = j-i;
                    break;
                }
                answer[i] = prices.length-1-i;
            }
        }
        return answer;
    }
}
