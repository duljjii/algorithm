import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 센서의 개수
        int K = scanner.nextInt(); // 집중국의 개수
        int[] sensors = new int[N];

        for (int i = 0; i < N; i++) {
            sensors[i] = scanner.nextInt();
        }

        int result = findMinCoverage(N, K, sensors);
        System.out.println(result);
    }

    public static int findMinCoverage(int N, int K, int[] sensors) {
        if (K >= N) return 0; // 집중국이 센서의 개수보다 많을 경우, 모든 센서를 커버 가능하므로 거리의 합은 0

        Arrays.sort(sensors); // 센서의 위치를 정렬

        int[] distances = new int[N-1]; // 각 센서 간의 거리를 저장할 배열

        for (int i = 0; i < N-1; i++) {
            distances[i] = sensors[i+1] - sensors[i];
        }

        Arrays.sort(distances); // 거리를 정렬

        for (int i = 0; i < K-1; i++) { // 가장 긴 거리들을 K-1개 무시
            distances[N-2-i] = 0;
        }

        int result = 0;

        for (int distance : distances) {
            result += distance;
        }

        return result;
    }
}
