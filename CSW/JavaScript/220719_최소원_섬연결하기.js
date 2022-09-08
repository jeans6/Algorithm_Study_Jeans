function solution(n, costs) {
    let cost = 0;
    
    const parent = Array.from({length:n+1}, ()=>0);
    //부모가 자기자신을 가르키도록 초기화
    for(let i =0; i<parent.length; i++){
        parent[i] = i;
    }
    //Union-Find
    const getParent = (x)=>{
        if(parent[x] === x) return x;
        return getParent(parent[x]);
    }
    
    const unionParent = (a,b)=>{
        a = getParent(a);
        b = getParent(b);
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }
    
    const findParent = (a,b) =>{
        a = getParent(a);
        b = getParent(b);
        if(a===b) return 1;
        else return 0;
    }
     
    // 비용 작은 순서대로 정렬
    costs.sort((a,b)=>a[2]-b[2]);
    
    costs.map((e)=>{
        if(!findParent(e[0], e[1])){
            unionParent(e[0],e[1]);
            cost += e[2];
        }      
    })
    
    return cost;
}