import java.util.*;
import java.io.*;

public class Main {
    static int R;
    static int C;
    static int T;

    static int[] ac1;
    static int[] ac2;

    static int[][] arr;

    static Queue<int[]> q = new LinkedList<>();

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        arr = new int[R][C];
        T = stoi(st.nextToken());
        ac1 = new int[2];
        ac2 = new int[2];
        boolean check = true;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                arr[i][j] = stoi(st.nextToken());
                if (arr[i][j] == -1) {
                    if (check) {
                        check = false;
                        ac1[0] = i;
                        ac1[1] = j;
                    } else {
                        ac2[0] = i;
                        ac2[1] = j;
                    }
                } else if (arr[i][j] != 0) {
                    q.add(new int[]{i, j, arr[i][j]});
                }
            }
        }
        for (int i = 0; i < T; i++) {
            spread();
            clean();
            fillDust();
        }
        int ans = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                ans += arr[i][j];
            }
        }
        System.out.println(ans+2);

    }

    private static void fillDust() {
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arr[i][j] != -1 && arr[i][j] != 0){
                    q.add(new int[]{i, j, arr[i][j]});
                }
            }
        }
    }

    public static void spread() {
        int[][] tmp = new int[R][C];
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dust = cur[2];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isValid(nr, nc) && arr[nr][nc] != -1) {
                    tmp[nr][nc] += dust / 5;
                    tmp[r][c] -= dust / 5;
//                    System.out.println("확산 후 tmp[r][c] = " + arr[r][c] + " " + tmp[r][c]);
                }
            }


        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i][j] += tmp[i][j];
            }
        }


    }

    static void clean() {
        moveDown1();
        moveLeft1();
        moveUp1();
        moveRight1();

        moveUp2();
        moveLeft2();
        moveDown2();
        moveRight2();
    }

    static void moveDown1() {
        for (int i = ac1[0]; i > 0; i--) {
            if (arr[i][0] != -1) {
                arr[i][0] = arr[i - 1][0];
            }
        }

    }

    static void moveLeft1() {
        for (int i = 0; i < C - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }

    }

    static void moveUp1() {
        for (int i = 0; i < ac1[0]; i++) {
            arr[i][C - 1] = arr[i + 1][C - 1];
        }

    }

    static void moveRight1() {
        for (int i = C - 1; i > 0; i--) {
            arr[ac1[0]][i] = arr[ac1[0]][i - 1];
        }
        arr[ac1[0]][1] = 0;

    }

    static void moveUp2() {
        for (int i = ac2[0]; i < R - 1; i++) {
            if (arr[i][0] != -1) {
                arr[i][0] = arr[i + 1][0];
            }
        }
        arr[R - 1][0] = 0;

    }

    static void moveDown2() {
        for (int i = R - 1; i > ac2[0]; i--) {
            arr[i][C-1] = arr[i - 1][C-1];
        }
        arr[ac2[0]][C-1] = 0;

    }


    static void moveLeft2() {
        for (int i = 0; i < C - 1; i++) {
            arr[R - 1][i] = arr[R - 1][i + 1];
        }
    }

    static void moveRight2(){
        for(int i=C-1; i>0; i--){
            arr[ac2[0]][i] = arr[ac2[0]][i-1];
        }
        arr[ac2[0]][1] = 0;


    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean isValid(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}