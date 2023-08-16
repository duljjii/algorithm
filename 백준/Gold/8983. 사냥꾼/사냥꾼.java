import java.util.*;
import java.io.*;
class Main{
    private static int stoi(String str){
        return Integer.parseInt(str);
    }
    private static int N, M, L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = stoi(st.nextToken());
        int N = stoi(st.nextToken());
        int L = stoi(st.nextToken());
        List<Integer> plst = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            plst.add(stoi(st.nextToken()));
        }
        Collections.sort(plst);
        int answer = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int c = stoi(st.nextToken());
            int r = stoi(st.nextToken());
            int start = 0;

            int end = plst.size()-1;
            boolean flag = false;
            while(start <= end){
                int mid = (start+end)/2;
                if(plst.get(mid) < c){
                    start = mid + 1;
                }else if(plst.get(mid) > c){
                    end = mid - 1;
                }else{
                    if(r <= L){
                        answer++;
                        flag = true;
                        break;
                    }else{
                        break;
                    }
                }
            }
           if(!flag){
               if(start < plst.size()){
                     if(Math.abs(plst.get(start)-c) + r <= L){
                          answer++;
                          continue;
                     }
               }
              if(start+1 < plst.size()){
                  if(Math.abs(plst.get(start+1)-c) + r <= L){
                      answer++;
                      continue;
                  }
              }
              if(end >= 0){
                  if(Math.abs(plst.get(end)-c) + r <= L){
                      answer++;

                  }
              }

            }
        }
        System.out.println(answer);
    }
}