class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++) {
            String str = skill_trees[i];
            int sIdx = 0;
            boolean isPre = true;
            for(int j = 0; j < str.length(); j++) {
                if(!skill.contains(String.valueOf(str.charAt(j)))) continue;
                // 선행 스킬이 필요한 경우
                if(skill.indexOf(str.charAt(j)) <= sIdx) {
                    sIdx++;
                } else {
                    isPre = false;
                    break;
                }
            }
            if(isPre) answer++;
        }
        return answer;
    }
}