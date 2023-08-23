import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    private static int N;

    private static class Node{
        int a;
        int b;
        Node(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    private static int stoi(String s){
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] lst = new int[N];
        Map<Integer, List<Node>> map = new HashMap<>();

        for(int i=0; i<N; i++){
            lst[i] = stoi(st.nextToken());
        }

        for(int i=0; i<N-1; i++){
            for(int j = i+1; j<N; j++){
                int num1 = lst[i];
                int num2 = lst[j];
                if(!map.containsKey(num1 + num2)){
                    map.put(num1 + num2, new ArrayList<>());
                }
                map.get(num1 + num2).add(new Node(i, j));
            }
        }
        int ans =0;

        for(int i=0; i<N; i++){
            int num = lst[i];
            if (map.containsKey(num)) {
                for(Node node : map.get(num)){
                    if(node.a != i && node.b != i){
                        ans++;
                        break;
                    }
                }

            }
        }
        System.out.println(ans);
    }
}