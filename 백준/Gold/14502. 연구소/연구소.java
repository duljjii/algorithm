import java.util.*;
import java.io.*;

class Main {
    private static int N;
    private static int M;

    private static int[][] arr;
    private static int[] lst;

    private static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        arr = new int[N][M];
        lst = new int[N*M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = stoi(st.nextToken());
                lst[i*M + j] = arr[i][j];
            }
        }

        for(int i=0; i<N*M; i++){
            if(lst[i] == 0){
                zeroCheck(i, 0, arr);
            }
        }
        System.out.println(answer);
    }
    private static int answer;
    private static void zeroCheck(int start, int k ,int[][] arr){
        if(k == 3) {
            answer = Math.max(bfs(arr), answer);
            return;
        }
        for(int i=start; i<N*M; i++){
            int r = i/M;
            int c = i%M;
            if(arr[r][c] != 0 ){
                continue;
            }
            arr[r][c] = 1;
            zeroCheck(i+1, k+1, arr);
            arr[r][c] = 0;
        }
    }

    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int bfs(int[][] arr){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

            while(!q.isEmpty()){
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for(int d = 0; d<4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(isValid(nr, nc) && !visited[nr][nc] && arr[nr][nc] == 0){
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            int cnt = 0;
            for(int i=0; i<N; i++){
                for(int j = 0; j<M; j++){
                    if(!visited[i][j] && arr[i][j] == 0){
                        cnt++;
                    }
            }
        }
            return cnt;
    }

    private static boolean isValid(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}