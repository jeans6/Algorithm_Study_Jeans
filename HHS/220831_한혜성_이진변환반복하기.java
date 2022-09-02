class Solution {
    public int[] solution(String s) {
        
        //0의 개수 일단 세어놓고
        //나머지 1의 개수를 2진법으로 바꾼 후
        //길이가 1이 아니면 위 과정 반복
        //그때마다 횟수 올리고 0의 개수도 올리기
        int zeroCnt = 0;
        int binCnt = 0;
        while(s.length() > 1){
            binCnt++;
            int oneCnt = 0;
            
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0')
                    zeroCnt++;
                else 
                    oneCnt++;
            }
            String num ="";
            while(oneCnt > 0){
                num += oneCnt%2;
                oneCnt /= 2;
            }
            s = num;
        }
        int [] answer = new int[2];
        answer[0] = binCnt;
        answer[1] = zeroCnt;
        return answer;
    }
}