import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String, Integer> dict = new HashMap<>();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i = 0; i < 26; i++){
            dict.put(alpha.substring(i,i+1), i+1);
        }
        
        int lastNum = 27;
        for(int i = 0; i < msg.length(); i++){
            //i번째 인덱스부터 하나씩 더 추가하면서 맵에 있는지 확인하고 없으면 추가하고 그 전까지의 값 번호 출력
            String str = "";
            boolean check = false;
            for(int j = i; j < msg.length()-1; j++){
                str += msg.charAt(j);
    
                if(dict.containsKey(str) && !dict.containsKey(str+msg.charAt(j+1))){
                    ans.add(dict.get(str));
                    dict.put(str+msg.charAt(j+1), lastNum++);
                    i = j;
                    check = true;
                    break;
                }
            }
            if(!check){
                str = msg.substring(i, msg.length());
                ans.add(dict.get(str));
                break;
            }
        }
        int[] answer = new int[ans.size()];
        
        for(int i = 0; i < ans.size(); i++)
            answer[i] = ans.get(i);
            
        
        return answer;
    }
}