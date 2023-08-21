import java.util.*;
import java.io.*;
class Main{

    private static int N, d, k, c;

    private static int[]sushi;

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = stoi(st.nextToken());
        int d = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int c =  stoi(st.nextToken());

        sushi = new int[N];


        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for(int i=0; i<N; i++){
           st = new StringTokenizer(br.readLine(), " ");
            sushi[i]=  stoi(st.nextToken());
        }
        set.add(c);
        for(int i=0; i<N; i++){
            for (int j = i; j < i+k; j++) {
                int idx = j;
                if(idx > N-1){
                    idx = idx - N;
                }
                set.add(sushi[idx]);
            }
            answer = Math.max(answer, set.size());
            set.clear();
            set.add(c);
        }
        System.out.println(answer);

    }
}