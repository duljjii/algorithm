import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;

    static int stoi(String str) {
        return Integer.parseInt(str);
    }

    private static int[] dr = new int[]{-1, 1, 0, 0};
    private static int[] dc = new int[]{0, 0, -1, 1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }

        int ans = 0;
        // 1. 외부공기 체크하기 (맨 가장자리를 통해 외부공기 모두 체크)
        setting_bfs();
        // 2. 내부공기는 따로 체크하기 위해 2로 바꾸기
        settingInnerAir();

        while (true) {
            if (meltCheese()) {
                System.out.println(ans);
                return;
            } else {
                ans++;
                // 내부 공기 체크하기
                innerAirCheck();
            }
        }
        // 3. 치즈 녹이기
        // 치즈가 존재하지 않는다면 종료


    }

    private static void setting_bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            visited[r][c] = true;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isValid(nr, nc) && !visited[nr][nc] && arr[nr][nc] == 0) {
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

        }


    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static void settingInnerAir() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    arr[i][j] = 2;
                }
            }
        }
    }

    private static boolean meltCheese() {
        boolean check = true;
        List<int[]> lst = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    check = false;
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (isValid(nr, nc) && visited[nr][nc]) {
                            cnt++;
                        }
                    }
                    if (cnt >= 2) {
                        arr[i][j] = 0;
                        lst.add(new int[]{i, j});
                    }
                }
            }
        }
        for (int[] pos : lst) {
            int r = pos[0];
            int c = pos[1];
            visited[r][c] = true;
        }
        return check;
    }

    private static void innerAirCheck() {
        boolean[][] tmp_visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (isValid(nr, nc) && !tmp_visited[nr][nc] && arr[nr][nc] == 0) {
                            bfs(i, j);
                        }
                    }
                }
            }
        }
    }
    private static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            r = pos[0];
            c = pos[1];
            visited[r][c] = true;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isValid(nr, nc) && !visited[nr][nc] && arr[nr][nc] == 2) {
                    q.add(new int[]{nr, nc});
                    arr[nr][nc] = 0;
                    visited[nr][nc] = true;
                }
            }

        }
    }
}