function solution(answers) {
    var answer = [];

    // 각 학생들의 찍는 번호 패턴
    const first =[1,2,3,4,5];
    const second =[2,1,2,3,2,4,2,5];
    const third =[3,3,1,1,2,2,4,4,5,5];
    
    const checkScore = []; //id : 맞힌정답수
    let firstNum =0;
    let secondNum =0;
    let thirdNum =0;
    
    for(let i =0; i<answers.length; i++){
        if( answers[i] === first[i%5]){
            firstNum +=1;
        }
        if(answers[i] === second[i%8]){
            secondNum+=1;
        }
        if(answers[i] === third[i%10]){
            thirdNum+=1;
        }
    }
    checkScore[0] = firstNum;
    checkScore[1] = secondNum;
    checkScore[2] = thirdNum;
    
    const maxScore = Math.max(...checkScore);
    for(let i=0; i<3; i++){
        // index에 1씩 더해야 학생번호가 됨
        if(checkScore[i]===maxScore) answer.push(i+1);
    }
    
    
    
    
    return answer;
}