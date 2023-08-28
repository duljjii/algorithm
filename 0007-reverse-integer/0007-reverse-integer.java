import java.util.*;
class Solution {
    public int reverse(int x) {
       
        if( x== 0){
            return 0;
        }
        int pm = 1;
        if( x < 0 ){
            pm = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(x);
        String[] lst = sb.toString().split("");
        System.out.println(Arrays.toString(lst));
        sb.setLength(0);
        for(int i=lst.length - 1; i>=0; i--){
            if(x < 0 && i == 0){
                continue;
            }
            sb.append(lst[i]);
        }
        int ans = 0;
        Long tmp = Long.valueOf(sb.toString());
        if(x<0){
            tmp *= -1;
        }
        if(tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE){
            return 0;
        }else{
            ans = Integer.valueOf(sb.toString());
        }
        return ans * pm;
    }
}