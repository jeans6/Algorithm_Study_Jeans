import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playsByGenres = new HashMap<>();
        List<Music> musicList = new ArrayList<>();
        
        // playsByGenres에 장르별 재생횟수 저장
        for(int i = 0; i < genres.length; i++) {
            playsByGenres.put(genres[i], 
                              playsByGenres.getOrDefault(genres[i], 0) + plays[i]);
        }
        // music에 고유번호별 장르, 재생횟수, 장르별 재생 횧수 저장
        for(int i = 0; i < genres.length; i++) {
            musicList.add(new Music(i, genres[i], plays[i], playsByGenres.get(genres[i])));
        }
        // music을 장르별 재생수로 정렬 및 재생순 별로 정렬 및 고유 번호별로 정렬
        Collections.sort(musicList, new Comparator<Music>() {
            @Override
            public int compare(Music m1, Music m2) {
                int compareGenre = m2.playsByGenre - m1.playsByGenre;
                if(compareGenre != 0) return compareGenre;
                int comparePlay = m2.play - m1.play;
                if(comparePlay != 0) return comparePlay;
                return m1.num - m2.num;
            }
        });
        
        // 조건에 맞게 정렬된 musicList에서 장르별 최대 2곡 씩만 bestAlbum에 넣어줌
        List<Integer> bestAlbum = new ArrayList<>();
        int prev = musicList.get(0).playsByGenre;
        int cnt = 0;
        for(int i = 0; i < musicList.size(); i++) {
            Music m = musicList.get(i);
            if(cnt < 2 && m.playsByGenre == prev) {
                bestAlbum.add(m.num);
                cnt++;
            } else if(cnt == 2 && m.playsByGenre != prev) {
                cnt = 1;
                prev = m.playsByGenre;
                bestAlbum.add(m.num);
            } else if(i+1 < musicList.size() && cnt < 2 && m.playsByGenre != prev) {
                cnt = 0;
                prev = musicList.get(i+1).playsByGenre;
                bestAlbum.add(m.num);
            } else if(cnt < 2 && m.playsByGenre != prev) {
                bestAlbum.add(m.num);
            };
        }
        return bestAlbum.stream().mapToInt(i->i).toArray();
    }
    
    class Music {
        public int num;
        public String genre;
        public int play;
        public int playsByGenre;
        
        public Music(int num, String genre, int play, int playsByGenre) {
            this.num = num;
            this.genre = genre;
            this.play = play;
            this.playsByGenre = playsByGenre;
        }
    }
}