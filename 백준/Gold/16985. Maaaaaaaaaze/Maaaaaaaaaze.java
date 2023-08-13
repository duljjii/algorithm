import java.util.*;
import java.io.*;

public class Main {
    public static class Board {
        public int[][] map;

        public Board[] rotatedBoard = new Board[4];

        public Board() {
            map = new int[5][5];
            this.rotatedBoard[0] = this;
        }

        public void makeBoard() {
            for (int i = 1; i <= 3; i++) {
                rotatedBoard[i] = new Board();
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        rotatedBoard[i].map[k][4 - j] = rotatedBoard[i - 1].map[j][k];
                    }
                }
            }
        }
    }

    public static Board[] boards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boards = new Board[5];
        for (int B = 0; B < 5; B++) {
            boards[B] = new Board();
            for (int i = 0; i < 5; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 5; j++) {
                    boards[B].map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boards[B].makeBoard();
        }
        perm(0, idxs);
        if (answer == 9999999) { // 수정: 정답이 갱신되지 않은 경우
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static boolean visited[] = new boolean[5];
    private static int[] idxs = new int[5];

    public static void perm(int k, int[] idxs) {
        if (k == 5) {
            dfs(0, idxs, selectedBoard);
            return;
        } else {
            for (int i = 0; i < 5; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                idxs[k] = i;
                perm(k + 1, idxs);
                visited[i] = false;
            }
        }
    }

    public static Board[] selectedBoard = new Board[5];
    public static int answer = 9999999;

    public static void dfs(int k, int[] idxs, Board[] lst) {
        if (k == 5) {
            boolean[][][] BoardVisited = new boolean[5][5][5];
            answer = Math.min(bfs(lst, BoardVisited), answer);
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                lst[k] = boards[idxs[k]].rotatedBoard[i];
                if (lst[0].map[0][0] == 0) continue;
                dfs(k + 1, idxs, lst);
            }
        }
    }

    public static class Person {
        int r;
        int c;
        int h;
        int depth;

        public Person(int r, int c, int h, int depth) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.depth = depth;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static boolean isValid(int r, int c, int h) {
        return r >= 0 && r < 5 && c >= 0 && c < 5 && h >= 0 && h < 5;
    }

    public static int bfs(Board[] lst, boolean[][][] visited) {
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(0, 0, 0, 0));
        while (!q.isEmpty()) {
            Person p = q.poll();
            int r = p.r;
            int c = p.c;
            int h = p.h;
            int depth = p.depth;
            if (p.depth > answer) {
                return 9999999;
            }
            if (r == 4 && c == 4 && h == 4) {

                return p.depth;
            }
            for (int dh = -1; dh <= 1; dh++) {
                int nh = h + dh;
                if (isValid(r, c, nh) && !visited[nh][r][c] && lst[nh].map[r][c] == 1) {
                    visited[nh][r][c] = true;
                    q.add(new Person(r, c, nh, depth + 1));
                }
            }
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isValid(nr, nc, h) && !visited[h][nr][nc] && lst[h].map[nr][nc] == 1) {
                    visited[h][nr][nc] = true;
                    q.add(new Person(nr, nc, h, depth + 1));
                }
            }
        }
        return 9999999;
    }
}
