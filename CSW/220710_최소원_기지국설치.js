function solution(n, stations, w) {
    let idx = 1;
    let cnt = 0;
    let len = stations.length;
    //첫번째 스테이션 앞부분
    cnt = stations[0]-w -1;
    if(cnt<0) cnt = 0;
    let station = Math.ceil(cnt/(2*w+1));

    //마지막 스테이션 뒷부분
    if(stations[len-1]+w<n){
        cnt = n-stations[len-1]-w;
        station += Math.ceil(cnt/(2*w+1));
    }
        
    for(let i=1; i<len; i++){
        cnt = stations[i]-w-(stations[i-1]+w)-1;
        station += Math.ceil(cnt/(2*w+1));
    }

    return station;
}