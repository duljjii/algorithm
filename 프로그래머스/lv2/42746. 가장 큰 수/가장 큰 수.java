import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> lst = new ArrayList<>();
        for(int num : numbers){
            lst.add(Integer.toString(num));
        }
        // 1. 정렬하기
        Collections.sort(lst, (String a, String b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        if(lst.get(0).equals("0")) return "0";
        for(String el : lst){
            sb.append(el);
        }
        
        return sb.toString();
    }
}