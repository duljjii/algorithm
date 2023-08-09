class Solution {
    
    public int numTeams(int[] rating) {
        int n = rating.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> minusMap = new HashMap<>();
        
        for(int i : rating){
            map.put(i, new ArrayList<>());
            minusMap.put(i, new ArrayList<>());
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(rating[i] < rating[j]){
                    map.get(rating[i]).add(rating[j]);
                    
                }else{
                    minusMap.get(rating[i]).add(rating[j]);
                }
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            int num = rating[i];
            List<Integer> lst = map.get(num);
            for(int j : lst){
                answer += map.get(j).size();
            }
            lst = minusMap.get(num);
            for(int j : lst){
                answer += minusMap.get(j).size();
            }
        }
        return answer;
    }
}