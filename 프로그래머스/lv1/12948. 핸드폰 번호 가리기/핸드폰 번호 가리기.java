import java.util.*;
import java.io.*;
class Solution {
    public String solution(String phone_number) {
        String answer = "";
        char[] lst = phone_number.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<lst.length-4;i++){
            sb.append("*");
        }
        for(int i=lst.length-4; i<lst.length; i++){
            sb.append(lst[i]);
        }

        answer = sb.toString();
        return answer;
    }
}