import java.util.*;
import java.io.*;
public class Main{
    public static int N;
    public static int M;

    public static int stoi(String str){
        return Integer.valueOf(str);
    }
    public static class Person{
        int r;
        int c;
        int depth;
        public Person(int r, int c, int depth){
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
    public static int[][] map;
    public static int[][] ans;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};
    public static boolean isValid(int r, int c, int sr, int sc){
        return r>=0 && r<N && c>=0 && c<M && (r!=sr || c != sc);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new int[N][M];
        ans = new int[N][M];
        for(int[] row : ans){
            Arrays.fill(row, -1);
        }

        int sr = 0;
        int sc = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                int num = stoi(st.nextToken());
                map[i][j] = num;

                if (num == 2){
                    sr = i;
                    sc = j;
                    ans[i][j] = 0;
                }
                if (num == 0) {
                    ans[i][j] = 0;
                }
            }
        }
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(sr, sc, 0));
        while(!q.isEmpty()){
            Person p = q.poll();
            int r = p.r;
            int c = p.c;
            int depth = p.depth;
            for(int d = 0; d< 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(isValid(nr, nc, sr, sc)){

                    if(map[nr][nc] == 1 && ans[nr][nc] == -1){
                        ans[nr][nc] = depth + 1;
                        q.add(new Person(nr, nc, depth+1));
                    }
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int[] row : ans){
            sb.setLength(0);
            for(int col : row){
                sb.append(col).append(" ");
            }
            System.out.println(sb.toString());
        }
    }
}