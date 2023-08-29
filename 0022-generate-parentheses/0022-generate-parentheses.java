class Solution {
    private static List<String> lst;
    public List<String> generateParenthesis(int n) {
        lst = new ArrayList<>();
        char[] pt = new char[n*2];
        dfs(0, 0, 0, pt);
        return lst;
    }
    private void dfs(int k, int left, int right, char[] pt){
        if((left == right) && left == pt.length / 2){
            lst.add(new String(pt));
            return;
        }else{
            if(left < pt.length/2){
                pt[k] = '(';
                dfs(k+1, left+1, right, pt);
            }
            if(right < left){
                pt[k] = ')';
                dfs(k+1, left, right+1, pt);
            }
        }
    }
}