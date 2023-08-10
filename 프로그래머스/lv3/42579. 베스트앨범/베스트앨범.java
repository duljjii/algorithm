import java.util.*;
import java.io.*;
class Solution {
    public static class Genre{
        int idx;
        int val;
        public Genre(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
                
        List<Integer> answerList = new ArrayList<>();
        // genres를 키로 두는 인덱스와
        Map<String, List<Genre>> map = new HashMap<>();
        int idx = 0;
        List<String> lst = Arrays.asList(genres);
        
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, List<Genre>> idxMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            if(sumMap.getOrDefault(genre, 0) == 0){
                sumMap.put(genre, 0);
                idxMap.put(genre, new ArrayList<>());
            }
            sumMap.put(genre, sumMap.get(genre)+plays[i]);
            idxMap.get(genre).add(new Genre(idx++, plays[i]));
            
        }

        List<String> sumList = new ArrayList<>(sumMap.keySet());
        sumList.sort((str1, str2) -> sumMap.get(str2) - sumMap.get(str1));
        
        for(String genre : sumList){
            List<Genre> idxList = idxMap.get(genre);
            idxList.sort(Comparator.comparing((Genre g)->g.val).reversed().thenComparing((g)->g.idx));
           answerList.add(idxList.get(0).idx);
            if(idxList.size() > 1){
                answerList.add(idxList.get(1).idx);
            }
        }
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}