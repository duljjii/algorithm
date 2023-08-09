class Solution {
    public static int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    static int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        int[] answer = new int[2];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            if(find(edge[1]) == find(edge[0])){
                answer = edge;
            }
            parent[find(edge[1])] = find(edge[0]);

        }
        return answer;
    }
}