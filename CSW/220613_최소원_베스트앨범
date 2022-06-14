function solution(genres, plays) {
    const compareGenres = {};
    const compareGenresSort=[];
    const playsSong = [];
    const results=[];
    // 장르별 재생횟수 
    for(let i=0; i<genres.length; i++){
        if(compareGenres[genres[i]]){
            compareGenres[genres[i]] += plays[i];  
        } else compareGenres[genres[i]] = plays[i];
    }
    
    // 재생횟수가 높은 순서대로 정렬
    for(let row in compareGenres){
        compareGenresSort.push([row,compareGenres[row]]);
    }
    compareGenresSort.sort((a,b)=>{
        return b[1]-a[1];
    })
    
    // 장르 속 노래들 노래 횟수 높은 순서대로 , 같다면 고유번호 낮은 순서대로
    for(let i=0; i<genres.length; i++){
        playsSong.push({id:i, genre: genres[i], play:plays[i]});
    }
    compareGenresSort.forEach(gen=>{
        const songs = playsSong.filter(song=> song.genre === gen[0]).sort((a,b)=> b.play - a.play);
        for(let i=0; i<2 && i<songs.length ; i++){
            results.push(songs[i].id);
        }
    })
    
    return results;
}