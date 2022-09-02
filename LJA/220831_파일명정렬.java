import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<FileInfo> sortList = new ArrayList<>();
        
        for(int i = 0; i < files.length; i++) {
            int headIdx = getHead(0, files[i]);
            int numberIdx = getNumber(headIdx, files[i]);
            // head, number에만 해당하는 인덱스들을 골라
            // sortList에 각각 넣어줌
            sortList.add(new FileInfo(i, files[i].substring(0, headIdx), Integer.parseInt(files[i].substring(headIdx, numberIdx))));
        }
        Collections.sort(sortList);
        
        int idx = 0;
        for(FileInfo f : sortList) {
            answer[idx++] = files[f.index];
        }
        return answer;
    }
    
    int getHead(int start, String str) {
        for(int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') return i;
        }
        return -1;
    }
    
    int getNumber(int start, String str) {
        for(int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c < '0' || c > '9') return i;
        }
        return str.length();
    }
    
    class FileInfo implements Comparable<FileInfo> {
        int index;
        String head;
        int number;
        
        FileInfo(int index, String head, int number) {
            this.index = index;
            this.head = head;
            this.number = number;
        }
        
        // compareTo를 통해 정렬
        @Override
        public int compareTo(FileInfo o) {
            int h = this.head.toLowerCase().compareTo(o.head.toLowerCase());
            if(h != 0) return h;
            int n = this.number - o.number;
            if(n != 0) return n;
            return this.index - o.index;
        }
    }
}