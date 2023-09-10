import java.util.*;
class Solution {

    static boolean[] sosuList;
    static boolean[] visited;
    static int answer;
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        answer = 0;
        sosuList = new boolean[4000];
        sosuList[0] = true;
        sosuList[1] = true;
        List<Integer> lst = new ArrayList<>();
        visited = new boolean[numbers.length()];
        for(int i=2; i<sosuList.length; i++){
            if(sosuList[i] == false){
                for(int j=2; i*j < sosuList.length; j++){
                    sosuList[i*j] = true;
                }
            }
        }
        for(int i=2; i<4000; i++){
            if(!sosuList[i]) lst.add(i);
        }
        // 7자리 수의 소수를 알아야함
        dfs(0, new StringBuilder(), numbers);
        for(int num : set){
            if(num == 1 || num == 0) continue;
            if(num < 4000 && sosuList[num] == false){
                answer++;
                continue;
            }
            boolean check = false;
            for(int sosu : lst){
                if(num % sosu == 0){
                    check = true;
                    break;
                } 
            }
            if(!check){
                answer++;
            }

        }
        return answer;
    }
    private static void dfs(int k, StringBuilder sb, String numbers){
        
        if(k == numbers.length()){
            if(sb.length() != 0){
                set.add(Integer.parseInt(sb.toString()));
            }
            return;
        }else{
            for(int i=0; i<numbers.length(); i++){
                if(visited[i]) continue;
                visited[i] = true;
                sb.append(numbers.charAt(i)+"");
                dfs(k+1, sb, numbers);
                visited[i] = false;
                sb.delete(sb.length() -1, sb.length());
                dfs(k+1, sb, numbers);
            }
        }
    }
    
}