import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
       answer = getUV(p);
     
        
        
        return answer;
    }
    
    private static String getUV(String p){
        if(p.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        String[] uv = new String[2];
        int left = 0;
        int right = 0;
        int idx = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='('){
                left +=1;
            }else{
                right +=1;
            }
            if(left == right){
                sb.append(p.charAt(i)+"");
                idx = i;
                break;
            }else{
                sb.append(p.charAt(i)+"");
            }
        }
        String u = "";
        if(sb.length() !=0){
            u = sb.toString();
        }
        sb.setLength(0);
        for(int i=idx+1; i<p.length(); i++){
            sb.append(p.charAt(i)+"");
        }
        String v = "";
        if(sb.length() != 0){
            v = sb.toString();
        }
        
        uv[0] = u;
        uv[1] = v;
        if(check(u)){
            return u + getUV(v);
        }
        StringBuilder tmpSb = new StringBuilder();
        tmpSb.append("(");
        tmpSb.append(getUV(v));
        tmpSb.append(")");
        u = u.substring(1, u.length()-1);
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                tmpSb.append(")");
            }else{
                tmpSb.append("(");
            }
        }
        
        
        return tmpSb.toString(); 
    }
    
    private static boolean check(String u){
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<u.length(); i++){
            if(u.charAt(i) == '('){
                stack.push('(');
            }else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}