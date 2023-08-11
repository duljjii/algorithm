import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> lst = new ArrayList<>();
        for(int num : arr){
            if(num % divisor == 0){
                lst.add(num);
            }
        }
        if(lst.size() == 0){
            lst.add(-1);
        }
        lst.sort((a, b) -> a-b);
        
        int[] answer = lst.stream().mapToInt(i->i.intValue()).toArray();
        
        return answer;

    }
}