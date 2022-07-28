function solution(a, edges) {    
    let answer = BigInt(0);
    let len = a.length;
    const tree = Array.from({length:len},()=>new Array());
    const visited = Array.from({length:len}, ()=>0);
    
    //a 배열의 합이 0이 아니면 return -1
    if(a.reduce((a,b)=>a+b) !== 0) return -1;
    
    edges.forEach((e)=>{
        let [a,b] = e;
        tree[a].push(b);
        tree[b].push(a);
    })
    
    const stack = [[0,0]];
    
    while(stack.length){
        let [cur, parent] = stack.pop();
        
        if(visited[cur]){
            answer += BigInt(Math.abs(a[cur]));
            a[parent] += a[cur];
            a[cur]=0;
            continue;
        }
        
        visited[cur] = 1;
        stack.push([cur, parent]);
        for(const next of tree[cur]){
            if(!visited[next]){
                stack.push([next, cur]);
            }
        }
        
    }
    
    return answer;    
}