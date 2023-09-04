class Solution {
    public int[][] merge(int[][] intervals) {
        
        // 1. 일단 첫번째 숫자로 정렬 
        // (정렬하면 오른쪽숫자와 다음 숫자의 왼쪽 수가 겹치는지 확인하면 됨)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> lst = new ArrayList<>();
        int N = intervals.length-1;
        // 2. N번 숫자 비교를 해서 합치기
         int idx = 1;
         int[] tmp = new int[2];
         tmp[0] = intervals[0][0];
         tmp[1] = intervals[0][1];
         while(N-- > 0){
            if(tmp[1] >= intervals[idx][0]){
               tmp[1] = Math.max(intervals[idx][1], tmp[1]); 
            }else{
                lst.add(tmp);
                tmp = new int[2];
                tmp[0] = intervals[idx][0];
                tmp[1] = intervals[idx][1];
            }
            idx++;
         }
         lst.add(tmp);
        int[][] ans = new int[lst.size()][2];
        int k = 0;
        for(int[] arr : lst){
            ans[k++] = arr;
        }
        return ans;
    }
}