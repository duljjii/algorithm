import java.util.*;
import java.io.*;
public class Main {
    private static int A;
    private static int B;
    public static int N;
    public static int M;
    private static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static int[][] map;
    public static class Robot{
        int[] lu;
        int[] ld;
        int[] ru;
        int[] rd;
        int depth;
        public Robot(int[] lu, int a, int b){
            this.lu = lu;
            this.ld = new int[]{lu[0]+a-1, lu[1]};
            this.ru = new int[]{lu[0], lu[1]+b-1};
            this.rd = new int[]{ld[0], ru[1]};
        }

        public static boolean isValid(int nr, int nc){
            return 0 <= nr && nr < N && 0 <= nc && nc < M;
        }
        public boolean movable(int d, int r, int c){
            if(d == 0){
                for(int i=lu[1]; i<=ru[1]; i++){
                    if(!isValid(r-1, i) || map[r-1][i] == 1) return false;
                }
            }else if (d==1){
                for(int i=ld[1] ; i<=rd[1]; i++){
                    if(!isValid(r+A, i) || map[r+A][i] == 1) return false;
                }
            }else if(d==2){
                for(int i=lu[0]; i<=ld[0]; i++){
                    if(!isValid(i, c-1) || map[i][c-1] == 1) return false;
                }
            }else{
                for(int i=ru[0]; i<=rd[0]; i++){
                    if(!isValid(i, c+B) || map[i][c+B] == 1) return false;
                }
            }
            return true;
        }
    }
    public static int stoi(String s) {return Integer.parseInt(s);}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        visited = new boolean[N][M];
        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        int K = stoi(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int blR = stoi(st.nextToken());
            int blC = stoi(st.nextToken());
            map[blR-1][blC-1] = 1;
        }
        st = new StringTokenizer(br.readLine(), " ");
        int sr = stoi(st.nextToken()) - 1;
        int sc = stoi(st.nextToken()) - 1;
        Robot robot = new Robot(new int[]{sr , sc}, A, B);
        st = new StringTokenizer(br.readLine(), " ");
        int er = stoi(st.nextToken());
        int ec = stoi(st.nextToken());
        visited[sr][sc] = true;
        Queue<Robot> q = new LinkedList<>();
        q.offer(robot);
        while(!q.isEmpty()){
            Robot currentRobot = q.poll();
            if (currentRobot.lu[0] == er-1 && currentRobot.lu[1] == ec-1){

                System.out.println(currentRobot.depth);
                return;
            }

            for(int d = 0; d < 4 ; d ++){
                if(currentRobot.movable(d, currentRobot.lu[0], currentRobot.lu[1])){
                    int nr = currentRobot.lu[0] + dr[d];
                    int nc = currentRobot.lu[1] + dc[d];
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        Robot nextRobot = new Robot(new int[]{nr, nc}, A, B);
                        nextRobot.depth = currentRobot.depth + 1;
                        q.offer(nextRobot);
                    }

                }
            }
        }
        System.out.println(-1);
    }
}