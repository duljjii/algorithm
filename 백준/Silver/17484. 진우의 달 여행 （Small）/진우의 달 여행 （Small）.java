import java.util.*;
import java.io.*;
public class Main {
    private static int[][] board;
    private static int N, M;

    private static int stoi(String str){
        return Integer.valueOf(str);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // stoi(st.nextToken());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        board = new int[N][M];
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                board[i][j] = stoi(st.nextToken());
            }
        }
        for(int i=0; i<M; i++){
            dfs(0, board[0][i], i, -1);
        }
        System.out.println(answer);
    }
    public static int answer=9999;
    private static void dfs(int k, int sum, int c, int prevDirection){
        if(k==N-1){
            answer = Math.min(answer, sum);
            return;
        }

        if(prevDirection == 0){
            dfs(k+1, sum+board[k+1][c], c, 1);
            if(c+1 < M){
                dfs(k+1, sum+board[k+1][c+1], c+1, 2);
            }
        }else if(prevDirection == 1){
            if(c-1 >= 0){
                dfs(k+1, sum+board[k+1][c-1], c-1, 0);
            }
            if(c+1 < M){
                dfs(k+1, sum+board[k+1][c+1], c+1, 2);
            }
        }else if(prevDirection == 2){
            if(c-1 >= 0){
                dfs(k+1, sum+board[k+1][c-1], c-1, 0);
            }
            dfs(k+1, sum+board[k+1][c], c, 1);
        }else{
            dfs(k+1, sum+board[k+1][c], c, 1);
            if(c+1 < M){
                dfs(k+1, sum+board[k+1][c+1], c+1, 2);
            }
            if(c-1 >= 0){
                dfs(k+1, sum+board[k+1][c-1], c-1, 0);
            }
        }

    }
}
