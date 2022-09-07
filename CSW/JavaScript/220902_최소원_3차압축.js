function solution(msg) {
    var answer = [];
    const dic = {};
    let idx = 'Z'.charCodeAt()-'A'.charCodeAt()+1;
    
    while(msg.length){
        const keys = Object.keys(dic);
        let word = '';
        //dic key에 있는 단어인지 검사
        for(let i=0; i<keys.length; i++){
            if(msg.indexOf(keys[i])===0){
                word = keys[i];
            }
        }
        let len = word.length;
        
        //사전에 포함되어 있는 경우
        if(len){
            answer.push(dic[word]);
            if(msg.length===len) break;
            let str = word + msg[len];
            idx++;
            dic[str] = idx;
            msg = msg.substr(len);
        }else{
            //없는 경우 문자 인덱스만 포함시키고 다음 단어포함 해서 사전에 등록
            answer.push(msg[0].charCodeAt()-'A'.charCodeAt()+1);
            if(msg.length===1) break;
            let str = msg[0]+msg[1];
            idx++;
            dic[str] = idx;
            msg = msg.substr(1);
        }
    }    

    return answer;
}