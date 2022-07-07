import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        PriorityQueue<Music> musicList = new PriorityQueue<>((o1, o2) -> {
            int time = o2.playTime - o1.playTime;
            if(time != 0) return time;
            return o1.idx - o2.idx;
        });
        
        for(int i = 0; i < musicinfos.length; i++) {
            String[] arr = musicinfos[i].split(",");
            // 시작시간, 끝시간을 통해 플레이 타임 구하기
            String startArr[] = arr[0].split(":");
            int startTime = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
            String endArr[] = arr[1].split(":");
            int endTime = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]);
            int playTime = endTime-startTime;
            String title = arr[2];
            System.out.println(title);
            StringBuilder sb = new StringBuilder(arr[3]);
            int sCnt = 0;
            for(int s = 0; s < sb.length(); s++) {
                if(sb.charAt(s)=='#') sCnt++;
            }
            int tempP = playTime;
            tempP+=sCnt;
            // 시간에 맞게 멜로디 늘려주기
            while(sb.length() <= tempP) {
                sb.append(arr[3]);
                tempP+=sCnt;
            }
            // 플레이 타임에 맞게 멜로디 자르기
            int cnt = 0;
            int endIdx = 0;
            for(int j = 0; j < sb.length(); j++) {
                if(j+1 < sb.length() && sb.charAt(j+1)=='#') {
                    cnt++;
                    j++;
                }
                endIdx++;
                if(endIdx == playTime) break;
            }
            String melody = "";
            if(sb.length() > playTime+cnt) melody = sb.substring(0, (playTime+cnt)).toString();
            
            // 같은 멜로디인지 체크
            for(int j = 0; j < melody.length(); j++) {
                boolean isSame = true;
                int mIdx = j;
                for(int k = 0; k < m.length(); k++) {
                    // 같은 멜로디?
                    if(melody.charAt(mIdx) == m.charAt(k)) { // 두 문자가 같다
                        // 샾 체크
                        if(mIdx+1 < melody.length() && melody.charAt(mIdx+1) == '#') {
                            mIdx++;
                            if(k+1 < m.length() && m.charAt(k+1) == '#') {
                                k++;
                            } else {
                                isSame = false;
                                break;
                            }
                        } else if(k+1 < m.length() && m.charAt(k+1) == '#') {
                            k++;
                            if(mIdx+1 < melody.length() && melody.charAt(mIdx+1) == '#') {
                                mIdx++;
                            } else {
                                isSame = false;
                                break;
                            }
                        }
                        if(mIdx+1 < melody.length()) mIdx++;
                    } else {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) musicList.add(new Music(playTime, title, i));
            }
        }
        if(musicList.size() == 0) return "(None)";
        
        answer = musicList.poll().title;
        return answer;
    }
    
    public class  Music {
        int playTime;
        String title;
        int idx;
        
        Music(int playTime, String title, int idx) {
            this.playTime = playTime;
            this.title = title;
            this.idx = idx;
        }
    }
}