import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        
        for(int i = 0; i < skill_trees.length; i++){
            String str = skill_trees[i];
  
            Stack<Character> stack = new Stack<>();
            for(int j = skill.length()-1; j >= 0; j--)
                stack.push(skill.charAt(j));            
            
            boolean chk = true;
            for(int j = 0; j < str.length(); j++){
                if(!stack.isEmpty() && stack.peek() == str.charAt(j))
                    stack.pop();
                else if(!stack.isEmpty() && stack.contains(str.charAt(j))){
                    chk = false;                    
                    break;
                }
            }
            if(chk) answer++;
        }
        
        return answer;
    }
}