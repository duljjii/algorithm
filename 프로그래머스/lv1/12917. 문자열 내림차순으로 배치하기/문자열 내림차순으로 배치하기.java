import java.util.*;
import java.io.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] lst = s.split("");
        Arrays.sort(lst, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(String str : lst){
            sb.append(str);
        }
        return sb.toString();
    }
}