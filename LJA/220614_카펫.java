class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 3, y = 3;
        int total = brown + yellow;
        
        // 세로가 가로보다 길어질 수 X
        for(int i = x; i < total/y+1; i++) {
            for(int j = y; j < total/x+1; j++) {
                // 가로*세로 == total이고,
                // 가로, 세로에서 각각 2줄을 뺀 사각형의 넓이는 노란 타일의 개수와 같다
                if(i*j == total && (i-2)*(j-2) == yellow) {
                    return new int[]{j, i};
                }
            }
        }
        return new int[]{};
    }
}