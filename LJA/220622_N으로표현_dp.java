import java.util.*;

class Solution {
    static int min = Integer.MAX_VALUE;
    
    public int solution(int N, int number) {
        // 1번부터 8번까지 연산으로 만들어 질 수 있는 모든 수들을 저장하기 위한 Set리스트 생성 및 초기화
        List<Set<Integer>> countList = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            countList.add(new HashSet<>());
        }
        countList.get(1).add(N); // 1번 연산으로 만들 수 있는 수는 N밖에 없음
        
        // 연산 결과 저장하기
        for(int i = 2; i < 9; i++) {
            Set<Integer> countSet = countList.get(i);
            for(int j = 1; j <= i; j++) {
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i-j);
                for(int preNum : preSet) {
                    for(int postNum : postSet) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);
                        if(preNum != 0 && postNum != 0) countSet.add(preNum / postNum);
                    }
                }
            }
            // N, NN, NNN, ... 추가하기
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        // countList에 표현할 숫자가 있는 리스트의 index를 리턴
        for(Set<Integer> sub : countList) {
            if(sub.contains(number)) return countList.indexOf(sub);
        }
        return -1;
    }
}
// 참고 : https://small-stap.tistory.com/65