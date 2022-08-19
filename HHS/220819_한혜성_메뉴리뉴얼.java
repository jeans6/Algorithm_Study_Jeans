import java.util.*;

class Solution {
    
    static HashMap<String, Integer> menu;
    static HashSet<String> result;
    static int count;
    
    public String[] solution(String[] orders, int[] course) {
        
        menu = new HashMap<>();//메뉴들로 나온 조합
        result = new HashSet<>();//많이 나온 조합
        //들어오는 메뉴들을 필요한 개수만큼 조합해서 map.put
        //만약 기존에 있는 조합이 map에 들어오는거라면 value++
        //그 후에 resultMap 정렬해서 answer에 넣기
        
        for(int i = 0; i < orders.length; i++){
            //조합 만들기
            String [] a = orders[i].split("");
            Arrays.sort(a);
            orders[i] = "";
            for(String s : a)
                orders[i] += s;
        }   
        for(int i = course.length-1; i >= 0; i--){
            count = 0;
            for(int j = 0; j < orders.length; j++){
                if(orders[j].length() >= course[i])
                    Combi(orders[j], course[i], 0, 0, "");
            }
            //count >= 2이고 해당 카운트를 가지고 있는 애들을 res에 넣기
            if(count < 2) continue;
            for(String key : menu.keySet()){
                if(count == menu.get(key))
                    result.add(key);
            }            
        }
        ArrayList<String> res = new ArrayList<>(result);
        Collections.sort(res);
        
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            answer[i] = res.get(i);
        }
        
        return answer;
    }
    
    private static void Combi(String food, int size, int start, int cnt, String ans){
        if(cnt == size){
            
            if(menu.containsKey(ans)){
                menu.put(ans, menu.get(ans)+1);
            }
            else
                menu.put(ans, 1);
            
            count = Math.max(count, menu.get(ans));
            return;
        }
        
        for(int i = start; i < food.length(); i++){
            String temp = ans + food.charAt(i);
            Combi(food, size, i+1, cnt+1, temp);
        }
        
    }
}