function solution(m, musicinfos) {
    const answer = [];
    // #이 붙은 문자들을 다른 문자들로 대체
    m = m
    .replace(/(C#)/g, "c")
    .replace(/(D#)/g, "d")
    .replace(/(F#)/g, "f")
    .replace(/(G#)/g, "g")
    .replace(/(A#)/g, "a");
    
    let len = m.length;
    const musicList =[];
    for(let i=0; i<musicinfos.length; i++){
        musicinfos[i] = musicinfos[i].split(",");
    }
    // 재생시간 계산
    for(const music of musicinfos){
        let first=music[0].split(":");
        let second=music[1].split(":");
        let start = second[0] - first[0];
        let end = second[1] - first[1];
        music[0] = first[0];
        music.push(start*60+end);
        music[3] = music[3]
          .replace(/(C#)/g, "c")
          .replace(/(D#)/g, "d")
          .replace(/(F#)/g, "f")
          .replace(/(G#)/g, "g")
          .replace(/(A#)/g, "a");
    }
    
    // 재생길이만큼 늘려서 m을 포함하는지 검사 
    for(const music of musicinfos){
        let length = music[3].length;
        let n = Math.floor(music[4]/length);
        let y = music[4]%length;
        let temp =  music[3].substr(0, y);
        let str ="";
        
        if(n===0){
            str = music[3].substr(0,music[4]);
        }else{
            str = music[3];
            for(let i=0; i<n; i++){
                str += music[3];
            }
            str += temp;
        }

        let idx = str.indexOf(m);
        if(idx!=-1) {
                answer.push(music);
        }
    }
    answer.sort((a,b)=>{
        if(a[4]===b[4]){
            return 0;
        }
        return b[4]-a[4];
    })
    return answer.length>0 ? answer[0][2] :"(None)";
}