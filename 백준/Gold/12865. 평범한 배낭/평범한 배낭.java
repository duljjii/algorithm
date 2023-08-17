import java.util.*;
import java.io.*;
public class Main{
    private static int N, M;

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        int[][] memo = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int w = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            for(int j=0; j<=M; j++){
                if(j >= w){
                    memo[i][j] = Math.max(memo[i-1][j], memo[i-1][j-w] + v);
                }else{
                    memo[i][j] = memo[i-1][j];
                }
            }
        }
        System.out.println(memo[N][M]);
    }
}