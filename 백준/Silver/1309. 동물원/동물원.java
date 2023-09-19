import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = countLionArrangement(N);
        System.out.println(result);
    }

    public static int countLionArrangement(int N) {
        int MOD = 9901;
        int[][] dp = new int[N+1][3];

        // 초기값 설정
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % MOD;
        }

        return (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
    }
}
