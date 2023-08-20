import java.util.*;
import java.io.*;
class Main {

    public static class Lecture implements Comparable<Lecture> {
        int data;
        int limitDate;

        public Lecture(int data, int limitDate) {
            this.data = data;
            this.limitDate = limitDate;
        }

        @Override
        public int compareTo(Lecture lecture) {
            return Integer.compare(this.limitDate, lecture.limitDate);
        }


    }

    private static int N;

    private static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        Lecture[] lst = new Lecture[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int data = stoi(st.nextToken());
            int limitDate = stoi(st.nextToken()) * - 1;
            Lecture lecture = new Lecture(data, limitDate);
            lst[i] = lecture;
        }
        PriorityQueue<Lecture> pq = new PriorityQueue<>();
        for(Lecture lect : lst){
            pq.add(lect);
        }
        Iterator<Lecture> iter = pq.iterator();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int ans = 0;
        for(int i=10000; i>0; i--){

            while(!pq.isEmpty() && i <= pq.peek().limitDate*-1){
                int num = pq.poll().data;
                pq2.add(num*-1);
            }
            if(!pq2.isEmpty()){
                ans += pq2.poll()*-1;
            }
        }

        System.out.println(ans);
    }
}