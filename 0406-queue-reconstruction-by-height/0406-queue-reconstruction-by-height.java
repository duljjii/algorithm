class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)-> {
            if(a[0]!=b[0]){
                return b[0]-a[0];
            }else{
                return a[1]-b[1];
            }
        });
        List<int[]> ans = new ArrayList<>();

        for(int[] lst : people){
            if(ans.size() == 0){
                ans.add(lst);
            }else{
            ans.add(lst[1], lst);

            }
        }
       
        return ans.stream().toArray(int[][]::new);
    }
}