import java.util.*;
import java.io.*;
class Main{

    static class Word{
        int idx;
        String word;
        Map<Character, Word> child;
        public Word(int idx, String word){
            this.idx = idx;
            this.word = word;
            this.child = new HashMap<>();
        }
        public String toString(){
            return "idx : " + idx + " word : " + word + " child : " + child.toString();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.valueOf(st.nextToken());
        Set<String> wordSet = new LinkedHashSet<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            wordSet.add(st.nextToken());
        }
        Word[] alpha = new Word[26];
        for(int i=0; i<26; i++){
            alpha[i] = new Word(-1, "");
        }
        List<String> wordList = new ArrayList<>(wordSet);
        // 1. wordList를 돌면서 해당 해당 접두사를 거쳐간 단어가 있는지 확인
        int idx = 0;
        int maxLength = 0;
        Word[] answer = new Word[2];
        for(String word : wordList){
            char start = word.charAt(0);
            Word cur = alpha[start-'a'];
            if (cur.idx == -1) {
                cur.word = word;
                cur.idx = idx;
            }else{
                if(maxLength <= 1){
                    if(answer[0] == null){
                        answer[0] = new Word(cur.idx, cur.word);
                        answer[1] = new Word(idx, word);
                    }else if(answer[0].idx > cur.idx){
                        answer[0] = new Word(cur.idx, cur.word);
                        answer[1] = new Word(idx, word);

                    }
                }
            }
            for(int i=1; i<word.length(); i++){
                char c = word.charAt(i);
                if (cur.child.containsKey(c)) {
                    cur = cur.child.get(c);
                    if(maxLength < i+1){
                            maxLength = i+1;
                            answer[0] = new Word(cur.idx, cur.word);
                            answer[1] = new Word(idx, word);

                    }else if(maxLength == i+1){
                        if(answer[0].idx > cur.idx){
                            answer[0] = new Word(cur.idx, cur.word);
                            answer[1] = new Word(idx, word);
                        }
                    }
                } else {
                    cur.child.put(c, new Word(idx, word));
                    cur = cur.child.get(c);
                }
            }
            idx++;
        }
        System.out.println(answer[0].word);
        System.out.println(answer[1].word);

    }
}