import java.util.*;

class Solution {
    static List<List<Integer>> adj = new ArrayList<>();
    static boolean[] wolf;
    static int ans;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        wolf = new boolean[info.length];
        
        for(int i=0; i<info.length; i++){
            adj.add(new ArrayList<>());
            if(info[i] == 1){
                wolf[i] = true;
            }
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        dfs(0, new ArrayList<>(), 0, 1, new boolean[info.length]);
        return ans;
    }
    private static void dfs(int i, List<Integer> lst, int wolfCnt, int sheepCnt, boolean[] visited){
        ans = Math.max(ans, sheepCnt);
        List<Integer> arr = new ArrayList<>();
        for(int num : adj.get(i)){
            if(!visited[num]){
                arr.add(num);
            }
        }
        for(int num : lst){
            if(!visited[num]){
                arr.add(num);
            }
        }
        
        for(int node : arr){
            if(!wolf[node] && !visited[node]){
                visited[node] = true;
                dfs(node, arr, wolfCnt, sheepCnt+1, visited);
                visited[node] = false;
            }
            if(wolf[node] && !visited[node] && sheepCnt - 1 > wolfCnt){
                visited[node] = true;
                dfs(node, arr, wolfCnt+1, sheepCnt, visited);
                visited[node] = false;
            }
        }
    }
}