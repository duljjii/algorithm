import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cardNumbers = scanner.nextLine();

        int result = countPossibleArrangements(cardNumbers);

        System.out.println(result);
    }

    public static int countPossibleArrangements(String cardNumbers) {
        int n = cardNumbers.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (cardNumbers.charAt(i-1) != '0') {
                dp[i] = dp[i-1];
            }

            int twoDigitNum = Integer.parseInt(cardNumbers.substring(i-2, i));
            if (twoDigitNum >= 10 && twoDigitNum <= 34) {
                dp[i] += dp[i-2];
            }
        }

        return dp[n];
    }
}
