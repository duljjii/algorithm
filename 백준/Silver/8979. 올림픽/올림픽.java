import java.util.*;
import java.io.*;
public class Main {
    public static int N, M;

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        List<int[]> lst = new ArrayList<int[]>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int num = stoi(st.nextToken());
            int gold = stoi(st.nextToken());
            int silver = stoi(st.nextToken());
            int bronze = stoi(st.nextToken());
            lst.add(new int[]{num, gold, silver, bronze});
        }
        Collections.sort(lst, (a, b)->{
            if(a[1] == b[1]){
                if(a[2] == b[2]){
                    if(a[3] == b[3]){
                        return 0;
                    }
                    return b[3] - a[3];
                }
                return b[2] - a[2];
            }
            return b[1] - a[1];
        });
        if(lst.get(0)[0] == M){
            System.out.println(1);
            return;
        }
        int idx = 1;
        for(int i=1; i<lst.size(); i++){
            int gold = lst.get(i)[1];
            int silver = lst.get(i)[2];
            int bronze = lst.get(i)[3];
            if(lst.get(i-1)[1] != gold || lst.get(i-1)[2] != silver || lst.get(i-1)[3] != bronze){
                idx++;
            }

            if(lst.get(i)[0] == M){
                System.out.println(idx);
                return;
            }

        }
    }
}
