import java.net.Inet4Address;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] player = new int[N+1][4];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            player[i][0] = Integer.parseInt(st.nextToken());
            player[i][1] = Integer.parseInt(st.nextToken());
            player[i][2] = Integer.parseInt(st.nextToken());
            player[i][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(player, (a, b)->{
            if(a[1] == b[1]){
                if(a[2] == b[2]){
                    return b[3] - a[3];
                }
                return b[2] - a[2];
            }
            return b[1] - a[1];
        });

        int idx = 1;
        if(player[0][0] == M){
            System.out.println(idx);
            return;
        }
        for(int i=1; i<N+1; i++){
            if(player[i][0] == M){
                System.out.println(idx);
                break;
            }
            if(player[i][0] == player[i-1][0] && player[i][1] == player[i-1][1] && player[i][2] == player[i-1][2]){
                continue;
            }
            idx++;
        }


    }

}