import java.io.*;
import java.util.*;
class Main{
    private static int N;
    private static int stoi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int[] lst = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            lst[i] = stoi(st.nextToken());
        }
        int ans = -1001;
        int tmp = 0;
        for(int i=0; i<N; i++){
           tmp += lst[i];
           ans = Math.max(ans, tmp);
           if(tmp < 0){
               tmp = 0;
           }
        }
        System.out.println(ans);
    }
}