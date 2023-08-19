import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            while(true){
            answer++;
            sb.setLength(0);
            sb.append(answer);
            String[] lst = sb.toString().split("");
            System.out.println(Arrays.toString(lst));
            boolean flag = true;    
                for(String str : lst){
                    if(Integer.valueOf(str) == 3){
                        flag = false;
                        break;
                    }
               
           }
                if(answer %3 != 0 && flag){
                    System.out.println("탈출!!" +answer);
                    break;
                }
            }
            
        }
        
        return answer;
    }
}