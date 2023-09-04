class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // 1. a제곱 + b제곱으로 정렬하면 간단하게 풀 수 있음

        Arrays.sort(points, (a, b) -> Integer.compare(pow(a[0])+pow(a[1]), pow(b[0])+ pow(b[1])));
        int[][] ans = new int[k][2];
        for(int i=0; i<k; i++){
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }
    private static int pow(int a){
        return a*a;
    }
}