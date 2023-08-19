import java.util.*;
import java.io.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int[] score = new int[3];
        int idx = 0 ;
        for(char c : dartResult.toCharArray()){
            if(c == 'S'){
                score[idx++] = Integer.valueOf(sb.toString());
                                sb.setLength(0);

            }else if(c=='D'){
                score[idx++] = Integer.valueOf(sb.toString()) * Integer.valueOf(sb.toString());
                                sb.setLength(0);

            }else if (c=='T'){
                score[idx++] = Integer.valueOf(sb.toString()) * Integer.valueOf(sb.toString()) * Integer.valueOf(sb.toString());
                                sb.setLength(0);

            }else if (c=='#'){
                score[idx-1] *= -1;
            }else if (c=='*'){

                score[idx-1] *= 2;
                if(idx -2 >= 0){
                    score[idx-2] *= 2;
                }
            }else{
                sb.append(c);
            }
            
        }
        for(int num : score){
            answer += num;
        }
        return answer;
    }
}