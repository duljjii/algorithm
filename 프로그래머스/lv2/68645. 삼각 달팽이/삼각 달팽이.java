import java.util.*;
class Solution {
    private static int r;
    private static int c;
    private static int k;
    private static int[][] board;
    public int[] solution(int n) {
        int[] answer = {};
        int N = n;
        r = 0;
        c = 0;
        k = 1;
        board = new int[n][n];
        List<Integer> lst = new ArrayList<>();
        board[0][0] = 1;
        // 1. move Down
        n--;
        moveDown(n);
        moveRight(n);
        int cnt = 0;
        n--;

        while(n>0){
            if(cnt == 0){
                moveUp(n);
            }else if(cnt == 1){
                moveDown(n);
            }else if(cnt == 2){
                moveRight(n);
              
            }
            n--;
            cnt++;
            if(cnt == 3) cnt = 0;

        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 0) break;
                lst.add(board[i][j]);
            }
        }
        return lst.stream().mapToInt(Integer::intValue).toArray();
        
    }
    private static void moveDown(int num){
        for(int i=0; i<num; i++){
            board[++r][c] = ++k;
        }
    }
    
    private static void moveRight(int num){
        for(int i=0; i<num; i++){
            board[r][++c] = ++k;
        }
    }
    private static void moveUp(int num){
        for(int i=0; i<num; i++){
            board[--r][--c] = ++k;
        }
    }
}