import java.util.*;

class Solution {
    static PriorityQueue<Music> music;

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        //우선순위 큐로 정렬 필요
        music = new PriorityQueue<>((o1, o2) ->{
            if(o1.time == o2.time)
                return o1.id - o2.id;
            return o2.time - o1.time;
        });
        StringTokenizer token = null;
        for(int i = 0; i < musicinfos.length; i++){
            //각 요소마다 자르기
            
            String [] info = new String[4];
            token = new StringTokenizer(musicinfos[i], ",");
            for(int j = 0; j < 4; j++){
                info[j] = token.nextToken();                
            }
            //시간을 분으로 계산 -> 시끼리 빼고 곱하기 60, 분끼리 빼고 서로 더하기
            //:을 기준으로 나누고 따로 빼내서 계산 -> 비효율적이지만 해본다.
            token = new StringTokenizer(info[0], ":");
            int sHour = Integer.parseInt(token.nextToken());
            int sMinute = Integer.parseInt(token.nextToken());
            
            token = new StringTokenizer(info[1], ":");
            int eHour = Integer.parseInt(token.nextToken());
            int eMinute = Integer.parseInt(token.nextToken());
            
            int time = (eHour-sHour)*60 + (eMinute - sMinute);
            
            //time크기만큼의 배열 만들어서 채워넣고 해당 m이 있으면 music에 넣기
            //메모리나 시간 터질거같은 느낌 -> 런타임에러
            //or
            //하나씩 늘려가면서 m과 같은지 확인하고 같으면 music에 넣기
            //내머리가 터질거같은 느낌
            int st = 0;
            while(st <= time){
                
                StringBuilder sb = new StringBuilder();
                for(int j = st; j < st+m.length(); j++){
                    int idx = j % (info[3].length());
                    sb.append(info[3].charAt(idx));
                }
                int lastCheck = (st + m.length()) % info[3].length();
                if(info[3].charAt(lastCheck) == '#')
                    sb.append('#');
                
                if(sb.toString().equals(m)){                    
                    music.add(new Music(time, i, info[2]));
                    break;
                }
                st++;

            }
        }
        
        if(music.size() > 0)
        return music.poll().title;
        else return "(None)";
    }
}

class Music{
    int time;
    int id;
    String title;
    public Music(int time, int id, String title){
        this.time = time;
        this.id = id;
        this.title = title;
    }
}
