class Solution {
    public String solution(String number, int k) {
        
        StringBuilder numbers = new StringBuilder();

        int id = 0;
        int len = number.length() - k;//최종 길이
        
        //만들어야 하는 길이만큼 돌리기
        for(int i = 0; i < len; i++){
            int Max = Integer.MIN_VALUE;
            
            // 다음 인덱스부터 돌리기
            for(int j = id; j <= k+i; j++){
                int temp = number.charAt(j)-'0';
                if(Max < temp){
                    Max = temp;
                    id = j+1;
                }
            } 
            
            numbers.append(Max);
        }
        return numbers.toString();
        
    }
}
//참고 코드 : https://suhyeokeee.tistory.com/142