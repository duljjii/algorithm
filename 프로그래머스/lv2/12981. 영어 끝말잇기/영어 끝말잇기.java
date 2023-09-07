import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
        
        // 해당 인덱스 %n 값들로 순서 정하기
        int cnt = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=n; i++){
            map.put(i, 0);
        }
        Map<String, Integer> wordMap = new HashMap<>();
        map.put(1, 1);
        wordMap.put(words[0], 1);
        cnt = 2;
        for(int i=1; i<words.length; i++){
          // 1. 이번 순서에 cnt가 몇번째 순서인지 체크
            map.put(cnt, map.get(cnt)+1);
            // 2. 이전 글자의 마지막과 cnt가 부른 글자의 첫 글자가 같은지 체크
            String prev = words[i-1];
            String now = words[i];
            if(prev.charAt(prev.length()-1) != now.charAt(0)){
               
                return new int[]{cnt, map.get(cnt)};
            }else if(wordMap.containsKey(now)){
               return new int[]{cnt, map.get(cnt)};
            }else{
                wordMap.put(now, 1);
                
            }
            cnt++;
            if(cnt > n) cnt = 1;
        }


        return new int[]{0, 0};
    }
}