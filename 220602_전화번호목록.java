import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 효율성이 도저히 안풀려서 다른 코드 참고했습니다
        /*
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }
        // 일반적으로 생각하는 배열안에 119로 시작하는 문자열이 있는지 확인하는 방법이 아닌
        // map안에 다 넣어놓고, 지금 비교하려는 문자열(11955)을 하나씩 자르면서 1,19,119가 map안에 있는지 확인하는 방법
        // 생각보다 엄청 빨라서 놀랐음..!
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j < phone_book[i].length(); j++) {
                if(map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }*/
        // 숫자 정렬이 아닌 문자정렬이기 때문에 바로 뒤에 데이터랑만 비교하는게 가능
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i].length() <= phone_book[i+1].length() && 
               phone_book[i].equals(phone_book[i+1].substring(0, phone_book[i].length()))) return false;
        }
        return answer;
    }
}