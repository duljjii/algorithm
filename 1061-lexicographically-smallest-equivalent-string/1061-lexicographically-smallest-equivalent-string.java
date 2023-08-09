class Solution {
    
    private static int find(int x){
        
        if(parent[x] != x)        
            parent[x] = find(parent[x]);
       
        return parent[x];
    }
    static int[] parent;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        for(int i=0; i<26; i++){
            parent[i] = i;
        }
        for(int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            int n1 = find(c1-'a');
            int n2 = find(c2-'a');
            if(n1 > n2){
                parent[n1] = n2;
            }else if(n2 > n1){
                parent[n2] = n1;
            }else{
                continue;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : baseStr.toCharArray()){
            sb.append((char)(find(c-'a')+'a'));
        }
        return sb.toString();
        
    }
}