class Solution {
    public int myAtoi(String s) {
        // 1. 공백 없애기
        s = s.trim();
        char[] lst = s.toCharArray();
        
        // 2. 숫자가 될 수 없는경우
        if(lst.length == 0){
            return 0;
        }

        // 2-1. 처음이 부호도 숫자도 아닐경우
        if(lst[0] != '+' && lst[0] != '-' && !Character.isDigit(lst[0])){
            return 0;
        }

        // 2-2. 처음이 부호이지만 2번째가 숫자가 아닌경우

        if(lst.length > 1 && (lst[0] == '+' || lst[0] == '-') && !Character.isDigit(lst[1])){
            return 0;
        }

        // 3. 부호 체크하기 
        int pm = 1;
        int idx = 0;
        if(lst[0] == '+' || lst[0] == '-'){
            idx = 1; // 첫 번째가 부호일경우 두 번재부터 시작
            if(lst[0] == '-') pm = -1;
        }

        // 4. 숫자 체크하기
        long tmp = 0;
        for(int i=idx; i<lst.length; i++){
            if(Character.isDigit(lst[i])){
                tmp *= 10;
                tmp += (int)lst[i] - '0';
            }else{
                break;
            }
            if(tmp * pm > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(tmp * pm < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }

        }
                return (int) tmp * pm;

        
    }
}