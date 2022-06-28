function solution(jobs) {

    // 작업요청시간 => 같다면 짧은 순으로 정렬
    jobs.sort((a,b) => a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
    const N = jobs.length;
    //총 걸린 시간
    let occupied = 0;
    //작업요청부터 완료까지 걸린 시간의 합
    let accumulated = 0;
    while(jobs.length > 0) {
        let group = jobs.filter(job => job[0] < occupied);
        if (group.length == 0) {
            // 처음 시작부분이거나 중간에 공백이 생긴다면 총 걸린 시간은 시작시간+소요시간
            const job = jobs.shift();
            occupied = job[0] + job[1];
            accumulated += job[1];
            continue;
        }

        let minIndex = -1;
        let minTime = Infinity;
        for (let i=0; i<group.length; i++) {
            const job = group[i];
            const time = job[1];
            if (time < minTime) {
                minTime = time;
                minIndex = i;
            }
        }
        const job = jobs.splice(minIndex, 1)[0];
        accumulated += occupied-job[0]+job[1];
        occupied += job[1];
    }

    return Math.floor(accumulated/N);
}