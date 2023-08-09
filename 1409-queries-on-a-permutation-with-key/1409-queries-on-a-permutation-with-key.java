class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] answer = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=m; i++){
            map.put(i, i-1);
        }
        int idx = 0;
        for(int i : queries){
            int num = map.get(i);
            answer[idx++] = num;
            map.put(i, 0);
            int cnt = 0;
            for(int j : map.keySet()){
                if(j == i) continue;
                if(map.get(j) < num){
                    map.put(j, map.get(j)+1);
                    cnt++;
                }
                if(cnt==num) break;

            }
            
        }   
        return answer;
    }
}