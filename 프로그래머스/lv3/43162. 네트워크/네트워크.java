import java.util.*;
import java.io.*;
class Solution {
    public static List<ArrayList<Integer>> adj;    
    public static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }else if(computers[i][j]==1){
                    adj.get(i).add(j);
                }
            }
        }
        for(int i=0; i<n; i++){
            boolean flag = bfs(i);
            if (flag){
                answer++;
            }
        }
        return answer;
    }
    public static boolean bfs(int n){
        Stack<Integer> stack = new Stack<>();
        if(visited[n] == true){
            return false;
        }else{
            visited[n] = true;
            stack.push(n);
            while(!stack.isEmpty()){
                int number = stack.pop();
                for(int num : adj.get(number)){
                    if(visited[num] == false){
                        visited[num] = true;
                        stack.push(num);
                    }
                }
            }
            return true;
        }

        
        
    }
}