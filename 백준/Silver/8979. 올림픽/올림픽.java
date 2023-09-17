import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] countries = new int[N][4]; // 국가 정보를 저장할 배열

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            countries[i][0] = Integer.parseInt(st.nextToken()); // 국가 번호
            countries[i][1] = Integer.parseInt(st.nextToken()); // 금메달 수
            countries[i][2] = Integer.parseInt(st.nextToken()); // 은메달 수
            countries[i][3] = Integer.parseInt(st.nextToken()); // 동메달 수
        }

        Arrays.sort(countries, (a, b) -> {
            if (a[1] == b[1]) {
                if (a[2] == b[2]) {
                    return b[3] - a[3];
                }
                return b[2] - a[2];
            }
            return b[1] - a[1];
        });

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (countries[i][0] == K) {
                System.out.println(rank);
                return;
            }
            if (i > 0 && Arrays.equals(countries[i], countries[i - 1])) {
                rank--;
            }
            rank++;
        }
    }
}
