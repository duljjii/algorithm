import java.util.*;
import java.io.*;
public class Main {
    private static int N;

    private static int[] lst;

    private static int S;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;


    private static int stoi(String str) {
        return Integer.valueOf(str);
    }

    public static void main(String[] args) throws IOException {

        setting();

        // 1. 시작 인덱스를 정하고 시작 인덱스 + S사이에서 가장 큰 값을 정한다.
        for (int i = 0; i < N - 1; i++) {
            int end = Math.min(i + S, N - 1); // end인덱스 구하기
            // 2. end위치까지 가면서 가장 큰 값과 그 인덱스를 구하낟.
            int max = findMax(i, end); // 가장 큰 값 인덱스 찾기
            // 3. 해당 인덱스와 현재 인덱스를 바꿔준다.
            if (S >= max - i && lst[i] < lst[max]) {
                swap(i, max);
            }
            if(S == 0){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : lst){
            sb.append(i).append(" ");
        }
        System.out.println(sb);


    }

    private static void setting() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        lst = new int[N];
        for (int i = 0; i < N; i++) {
            lst[i] = stoi(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        S = stoi(st.nextToken());

    }

    private static int findMax(int start, int end) {
        int idx = -1;
        int max = -1;
        for (int j = start + 1; j <= end; j++) {
            if (max < lst[j]) {
                max = lst[j];
                idx = j;
            }
        }
        if(idx == -1 || max == -1){
            return start;
        }
        return idx;
    }

    private static void swap(int si, int ei) {
        int end = lst[ei];
        // start부터 end-1까지 모두 1칸씩 증가
        for (int i = ei; i > si; i--) {
            lst[i] = lst[i-1];
        }
        lst[si] = end;
        S -= (ei - si);
    }
}