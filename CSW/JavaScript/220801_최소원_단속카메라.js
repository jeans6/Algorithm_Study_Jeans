function solution(routes) {
    let answer = 1;
    
    // 고속도로에서 나가는 점을 기준으로 오름차순 정렬
    routes.sort((a,b)=>{
        return a[1]-b[1];
    })
    
    let camera = routes[0][1];
    
    while(routes.length){
        let [routeIn, routeOut] = routes.shift();
        // 카메라가 범위 안에 없으면 갯수 더해주고 위치 바꿔줌
        if(camera > routeOut || camera < routeIn){
            answer++;
            camera = routeOut;
        }
        
    }
    
    return answer;
}