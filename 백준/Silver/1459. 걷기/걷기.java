import java.util.*;
import java.io.*;
class Main{
    private static int X;
    private static int Y;
    private static int W;
    private static int S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X= sc.nextInt();
        Y= sc.nextInt();
        W= sc.nextInt();
        S= sc.nextInt();

        long diag = 0;
        long ans = 0 ;
        // 해당 위치까지 직선 거리만 남을 때까지 이동
        if(W * 2 > S){
            diag = (long) S * Math.min(X, Y);
        }else{
            diag = (long) W * Math.min(X, Y) * 2;
        }
        ans += diag;
        int remain = Math.max(X, Y) - Math.min(X, Y);
        if(W > S) {
            // 대각선으로 이동하는게 더 이득인 경우
            // 단 직선거리는 대각선으로 이동할 경우 짝수만 이동 가능
            if (remain % 2 == 0) {
                ans += (long) remain * S;
            } else {
                ans += (long) (remain - 1) * S + W;

            }
        }else{
            ans += (long) remain * W;
        }

        System.out.println(ans);

    }
}