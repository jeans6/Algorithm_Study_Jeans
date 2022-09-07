function solution(id_list, report, k) {

    const reportedCnt ={}; //id별 신고당한 횟수
    const reportedBy ={}; //id별 신고자
    const mailCnt ={};
    
    // report 중복제거
    const reportedSet = new Set(report);
    
    // id별 신고받은 결과 (횟수, 신고자)
    // 초기화
    id_list.forEach((element)=>{
        reportedCnt[element] =0;
        reportedBy[element]=[];
        mailCnt[element]=0;
    });
    
    reportedSet.forEach((element)=>{
        const [id, reported] = element.split(" ");
        reportedCnt[reported] += 1;
        reportedBy[reported].push(id);
    });
    
    for(const reportedId in reportedCnt){
        if(reportedCnt[reportedId]>=k){
            reportedBy[reportedId].forEach((reporter)=>{
                  mailCnt[reporter] +=1;              
            });
        }
    }
    
    
    
    
    return id_list.map((id)=> mailCnt[id]);
}