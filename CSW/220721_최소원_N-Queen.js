function solution(n) {
    let answer = 0;
    const visitX = Array(n).fill(-1);
    
    //가능한 자리인지
    const canQ = (y,x) =>{
        //대각선 검사, y끼리 차이와 x끼리 차이가 같으면 대각선 상에 있는 것, 현재 열 전까지만 검사
        for(let i=0; i<y; i++){
            if(visitX[i] === x || Math.abs(visitX[i]-x)===Math.abs(y-i)) return 0;
        }
        return 1;
    }
    
    // 첫번째칸부터 Q를 두면서 재귀로 검사 
    const NQueen=(y)=>{
        // console.log(visitX, answer, y);
        if(y === n){
            answer++;
            return;
        }
            for(let j=0; j<n; j++){
                if(canQ(y,j)){
                    visitX[y] = j;
                    NQueen(y+1);
                    visitX[y] = -1;                    
                }
            }
    }
    
    for(let i=0; i<n; i++){
        visitX[0]=i;
        NQueen(1);
        visitX[0]=-1;
    }
    
    return answer;
}