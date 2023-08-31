import java.util.*;
import java.io.*;

class Main{

    static int N;

    static int[] dist;
    static int[] cost;

    static int stoi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());


        st = new StringTokenizer(br.readLine(), " ");

        dist = new int[N-1];
        for(int i=0; i<N-1; i++){
            dist[i] = stoi(st.nextToken());
        }

        cost = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            cost[i] = stoi(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        int sumCost = 0;

        for(int i=0; i<N-1; i++){
            min = Math.min(min, cost[i]);
            sumCost += min * dist[i];
        }

        System.out.println(sumCost);


    }
}