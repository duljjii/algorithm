import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] memo = new int[500][500];
        memo[0][0] = triangle[0][0];
        for(int i=0; i<triangle.length-1; i++){
            for(int j = 0; j< triangle[i+1].length; j++){
                memo[i+1][j] = Math.max(memo[i+1][j], triangle[i+1][j] + memo[i][j]);
                if(j+1 < triangle[i+1].length){
                memo[i+1][j+1] = Math.max(memo[i+1][j+1], triangle[i+1][j+1] + memo[i][j]);
                }
            }
        }
        answer = Arrays.stream(memo[triangle.length-1]).max().getAsInt();
        return answer;
    }
}