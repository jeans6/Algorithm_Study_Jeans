function solution(N, number) {
    var answer = 0;
    var use = Array.from(new Array(9), () => new Set()); //숫자 중복방지
    if(N==number) return 1;
    else {
        // index번 반복되는 숫자 추가 ex) 5,55,555, ...
        use.forEach((element, index) => {
            if (index !== 0) element.add(Number(String(N).repeat(index)));
        });
        // 피보나치 수열처럼 앞의 사칙연산 정보들이 필요 
        // ex) 숫자를 4번 사용할 시, 1번 쓴 결과값들과 3번 쓴 결과값들의 사칙연산[1,3], [2,2],[3,1] 을 계산하는 식으로 진행
        for(var i=1 ; i<=8 ; ++i) {
            for(var j=1 ; j<i ; ++j) {
                for(var first of use[j]) {
                    for(var second of use[i-j]) {
                        use[i].add(first+second);
                        use[i].add(first-second);
                        use[i].add(first*second);
                        use[i].add(first/second);
                    }
                } 
            }
            // N번 사용한 결과 저장할 때마다 number 값 가지고 있는지 검사
            if(use[i].has(number)) return i;
        }
        //8번 사용했을 때까지 검사하고 없으면 -1 리턴
        return -1;
    }
    return answer;
}