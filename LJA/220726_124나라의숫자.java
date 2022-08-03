import java.util.*;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] arr = {4, 1, 2};
        
        while(n > 0) {
            int remainder = n % 3;
            n /= 3;
            if(remainder == 0) n--;
            sb.append(arr[remainder]);
        }
        return sb.reverse().toString();
    }
}

// https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-124-%EB%82%98%EB%9D%BC%EC%9D%98-%EC%88%AB%EC%9E%90-Java