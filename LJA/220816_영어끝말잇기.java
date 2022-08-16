import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int i = 1;
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for(; i < words.length; i++) {
            if(list.contains(words[i])) break;
            String prev = list.get(i-1);
            if(prev.charAt(prev.length()-1) != words[i].charAt(0)) break;
            list.add(words[i]);
        }
        if(i == words.length) return new int[]{0, 0};
        return new int[]{i%n+1, (int)Math.ceil(i/n)+1};
    }
}