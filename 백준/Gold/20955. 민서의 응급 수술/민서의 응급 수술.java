import java.util.*;
import java.io.*;
public class Main {
    private static int N, M;

    private static int[] parent;

    private static int stoi(String str){
        return Integer.valueOf(str);
    }

    private static int find(int x){
        if(x != parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
        parent[0] = 1;
        int answer = 0;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            int realP = find(p);
            int realC = find(c);
            if(realP == realC){
                answer++;
                continue;
            }else{
                parent[realC] = realP;
            }
        }
        int rootNode = find(1);
        for(int node : parent){
            if(find(node) != rootNode){
                parent[find(node)] = rootNode;
                answer++;
            }
        }
        System.out.println(answer);

    }
}