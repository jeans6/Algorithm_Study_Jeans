import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] arr = new Integer[citations.length];
        for(int i = 0; i < arr.length; i++) arr[i] = citations[i];
        Arrays.sort(arr, Collections.reverseOrder());
        // 값이 위치보다 작거나 같아지는 위치 찾음
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <= i) {
                return i;
            }
        }
        return arr.length;
    }
}