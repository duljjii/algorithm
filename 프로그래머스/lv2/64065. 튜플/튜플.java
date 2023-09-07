import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> lst = new ArrayList<>();
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == '{'){
                lst.add(new ArrayList<>());
            }else if(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i)+"");
            }else if(s.charAt(i) == ','){
                if(sb.length() !=0){
                    lst.get(lst.size()-1).add(Integer.valueOf(sb.toString()));
                sb.setLength(0);
                }
            }else if(s.charAt(i) == '}'){
                if(sb.length() !=0){
                    lst.get(lst.size()-1).add(Integer.valueOf(sb.toString()));
                sb.setLength(0);
                }
                
            }
        }
        Collections.sort(lst, (a, b)-> a.size() - b.size());
        Set<Integer> set = new LinkedHashSet<>();
        for(List<Integer> tmp : lst){
            for(int num : tmp){
                set.add(num);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}