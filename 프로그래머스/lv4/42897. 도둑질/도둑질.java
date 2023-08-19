class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int N = money.length;
        int[] memo = new int[N];
        int[] memo2 = new int[N];
        // 첫번째 집을 선택 했을 경우
        memo[0] = money[0];
        memo[1] = memo[0];
        // 첫번째 집을 선택하지 않았을 경우
        memo2[0] = 0;
        memo2[1] = money[1];
    
        for(int i=2; i<N; i++){
            memo[i] = Math.max(memo[i-2] + money[i], memo[i-1]);
            memo2[i] = Math.max(memo2[i-2] + money[i], memo2[i-1]);
        }
        int ans1 = Math.max(memo[N-2], memo[N-3]);
        int ans2 = Math.max(memo2[N-1], memo2[N-2]);
        answer = Math.max(ans1, ans2);
        
        return answer;
    }
}