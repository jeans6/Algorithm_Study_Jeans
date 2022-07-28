import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 맵에 key = 판매원 이름, value=(판매원의 추천인, 판매원의 총이익금, 판매원의 인덱스)로 저장
        Map<String, SaleInfo> map = new HashMap<>();
        for(int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], new SaleInfo(referral[i], 0, i));
        }
        // 이익금 계산
        for(int i = 0; i < seller.length; i++) {
            int sum = (amount[i]*100);
            int yours = (int)(sum*0.1);
            int mine = sum-yours;
            // 나의 이익금을 계산해 map에 다시 넣어줌
            SaleInfo myInfo = map.get(seller[i]);
            myInfo.total += mine;
            map.put(seller[i], myInfo);
            String mentoName = myInfo.mento;
            // 상대방 배분금 계산
            while(!mentoName.equals("-")) {
                SaleInfo mentoInfo = map.get(mentoName);
                int temp = yours;
                yours = (int)(temp*0.1);
                mine = temp - yours;
                mentoInfo.total += mine;
                map.put(mentoName, mentoInfo);
                mentoName = mentoInfo.mento;
                if(yours == 0) break;
            }
        }
        
        int[] answer = new int[map.size()];
        for(String name : map.keySet()) {
            answer[map.get(name).index] = map.get(name).total;
        }
        return answer;
    }
    
    public class SaleInfo {
        String mento;
        int total;
        int index;
        
        SaleInfo(String mento, int total, int index) {
            this.mento = mento;
            this.total = total;
            this.index = index;
        }
    }
}