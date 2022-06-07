function solution(clothes) {
    var answer = 1;
    const clothesType = {};

    //중복된 옷 타입 갯수 세기
    clothes.forEach((x) => { 
        clothesType[x[1]] = (clothesType[x[1]] || 0)+1;    
        // 풀어서 쓰면
        // if(clothesType[x[1]]){	
        //      clothesType[x[1]] = clothesType[x[1]] + 1;
        //  }else { clothesType[x[1]] = 0 + 1;}
    });
    
    for (const spywear in clothesType){
        answer *= (clothesType[spywear]+1);
    }
    
    //아무것도 안입었을 경우 빼줘야됨
    return answer-1;
}