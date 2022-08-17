import java.util.*;

class Solution {
    
    static ArrayList<Integer> fee;
    static int initTime;
    static int initFee;
    static int addTime;
    static int addFee;
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> carTime = new HashMap<>();
        HashMap<Integer, Integer> carResult = new HashMap<>();
        fee = new ArrayList<>();    
        initTime = fees[0];
        initFee = fees[1];
        addTime = fees[2];
        addFee = fees[3];
        
        for(int i = 0; i < records.length; i++){
            String [] history = records[i].split(" ");
            StringTokenizer token = new StringTokenizer(history[0], ":");
            int hour = Integer.parseInt(token.nextToken());
            int minute = Integer.parseInt(token.nextToken());
            int sum = hour*60 + minute;
            int num = Integer.parseInt(history[1]);
            if(history[2].equals("IN")){
                map.put(num, sum);  
            }
            else{                
                int start = map.get(num);
                if(carResult.containsKey(num))
                    carResult.put(num, carResult.get(num)+sum-map.get(num));
                else 
                    carResult.put(num, sum-map.get(num));
                map.put(num, 1439);
            }
        }
        //출차 표시 안된 애들 다 23:59로 나가게 하기
        List<Integer> keyList = new ArrayList<>(map.keySet());
        for(int i = 0; i < keyList.size(); i++){
            int k = keyList.get(i);
            if(map.get(k) != 1439){
                int start = map.get(k);
                if(carResult.containsKey(k))
                    carResult.put(k, carResult.get(k)+1439-start);
                else 
                    carResult.put(k, 1439-start);
                map.put(k, 1439);
            }   
        }
        int[] answer = new int[keyList.size()];
        
        Collections.sort(keyList);
        for(int i = 0; i < keyList.size(); i++){
            answer[i] = cal(carResult.get(keyList.get(i)));
        }
           
        
        return answer;
    }
    private static int cal(int sum){
        int total = initFee;

        if(sum > initTime){
            int minus = sum - initTime;
            int div = minus / addTime;
            if(minus % addTime != 0)
                div++;
            total += div * addFee;
        }
        return total;

    }
}
