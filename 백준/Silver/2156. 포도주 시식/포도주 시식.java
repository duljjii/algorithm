import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int[] lst;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        lst = new int[N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            lst[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N];
        dp[0] = lst[0];
        if(N<3){
            System.out.println(Arrays.stream(lst).sum());
        }else{
            dp[1] = lst[0] + lst[1];
            dp[2] = Math.max(Math.max(lst[0]+lst[1], lst[0]+lst[2]), lst[1]+lst[2]);
            for(int i=3; i<N; i++){
                int tmp = Math.max(dp[i-3] + lst[i] + lst[i-1], dp[i-2] + lst[i]);
                dp[i] = Math.max(dp[i-1], tmp);
            }
            System.out.println(dp[N-1]);
        }


    }

}