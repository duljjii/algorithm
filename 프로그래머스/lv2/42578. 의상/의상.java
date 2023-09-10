import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String item = clothes[i][0];
            String category = clothes[i][1];
            if(!map.containsKey(category)){
                map.put(category, new ArrayList<>());
            }
            map.get(category).add(item);
        }
        answer = 1;
        for(String key : map.keySet()){
            
            answer *= map.get(key).size()+1;
        }
        return answer-1;
    }
}