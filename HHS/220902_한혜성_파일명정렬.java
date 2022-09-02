import java.util.*;

class Solution {
    static ArrayList<File> file;

    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        file = new ArrayList<>();
        for(int i = 0; i < files.length; i++){
            
            int startNum = findHead(files[i]);
            int endNum = findNum(startNum, files[i]);
            
            String h = files[i].substring(0, startNum).toUpperCase();
            int n = Integer.parseInt(files[i].substring(startNum, endNum));
            
            file.add(new File(i, h, n));
        }
        Collections.sort(file);
    
        for(int i = 0; i < files.length; i++){
            answer[i] = files[file.get(i).idx];
        }
        return answer;
    }
    
    private static int findHead(String str){
        int startNum = -1;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                startNum = i;
                break;
            }
        }
        return startNum;
    }
    
    private static int findNum(int start, String str){
        int endNum = Math.min(start+5, str.length());
        
        for(int i = start; i < endNum; i++){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){                
                endNum = i;
                break;
            }
        }
        return endNum;
    }
}
class File implements Comparable<File>{
    int idx;
    String head;
    int number;
    public File(int idx, String head, int number){
        this.idx = idx;
        this.head = head;
        this.number = number;
    }
    @Override
    public int compareTo(File f){
        if(this.head.compareTo(f.head) != 0)
            return this.head.compareTo(f.head);
        else {
            if(this.number - f.number != 0)
                return this.number - f.number;
            return this.idx - f.idx;
        }
    }
}