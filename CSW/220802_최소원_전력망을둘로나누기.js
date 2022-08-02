function solution(n, wires) {
    var answer = -1;
    let min = Infinity;
    const tree = Array.from({length:n+1}, ()=> new Array());
    
    // 트리에 노드 저장
    wires.map(e=>{
        let [a,b] = e;
        tree[a].push(b);
        tree[b].push(a);
    })
    
    // a,b를 끊고 연결된 자식노드 수 계산해서 최솟값찾기
    wires.map(e=>{
        let [a, b] = e;
        let filtered1 = tree[a].filter( v=> v!==b );
        let filtered2 = tree[b].filter(v =>v!==a);
        const visited = Array.from({length:n+1},()=>0);
        let flag = 0;
        
        visited[a] = 1;
        let filtered1N = 1;
        while(filtered1.length){
            let next = filtered1.shift();
            visited[next] = 1;
            filtered1N ++;
            tree[next].map(el=>{
                if(!visited[el]){
                    filtered1.push(el);
                }
            })
            
        }
        
        visited[b] = 1;
        let filtered2N = 1;
        while(filtered2.length){
            let next = filtered2.shift();
            visited[next] = 1;
            filtered2N ++;
            tree[next].map(el=>{
                if(!visited[el]){
                    filtered2.push(el);
                }
            })
            
        }
        let num = Math.abs(filtered1N-filtered2N);
        if(num<min){
            min = num;
        }   
        
    })
    
    return min;
}