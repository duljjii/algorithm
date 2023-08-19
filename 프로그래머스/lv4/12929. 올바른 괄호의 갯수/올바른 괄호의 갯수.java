class Solution {
    public static int answer;
    public int solution(int n) {
        dfs(0, 0, 0, n);
        return answer;
    }
    public static void dfs(int k, int left, int right, int n){
        if(k==n*2){
            if(left == right){
                answer++;
            }
            return;
        }
        // 1. left를 증가시키는 경우
        dfs(k+1, left+1, right, n);
        
        // 2. right를 증가시키는 경우 = left가 right보다 클 경우에만 가능
        if(left > right){
            dfs(k+1, left, right+1, n);
        }
        
        
        
        
    }
}