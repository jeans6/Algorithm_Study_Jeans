import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 비교를 위해 int 배열 -> String 배열로 변경
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = ""+numbers[i];
        }
        
        // Comparator 사용해 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        // 테케 11번
        if(arr[0].charAt(0)=='0') return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s : arr) sb.append(s);
        return sb.toString();
    }
}