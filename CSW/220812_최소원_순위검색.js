function solution(info, query) {
    var answer = [];
    const map = {};
    
    //"-"포함한 가능한 조합 만들어주기
    function combination(infos, score, start){
        let key = infos.join("");
        
        if(map[key]){
            map[key].push(score);
        }else{
            map[key] = [score];
        }
        
        for(let i=start; i<infos.length; i++){
            let arr = [...infos];
            arr[i] = '-';
            combination(arr, score, i+1);
        }
    }
    
    // 이분탐색
    function binarySearch(key, score){
        let scoreArr = map[key];
        if(scoreArr){
            let start = 0;
            let end = scoreArr.length;
            while(start<end){
                let mid = Math.floor((start+end)/2);
                if(scoreArr[mid] >= score){
                    end = mid;
                }else {
                    start = mid+1;
                }
            }
            return scoreArr.length-start;
        }
        
        return 0;
    }
    
    info.map(e=>{
        let infos = e.split(' ');
        let score = parseInt(infos.pop());
        combination(infos, score, 0);
    })
    
    for(let key in map){
        map[key].sort((a,b)=> a-b);
    }
    
    query.map(q=>{
        let s = q.replace(/ and /g," ").split(" ");
        let score = parseInt(s.pop());
        answer.push(binarySearch(s.join(""), score));
    })


    return answer;
}