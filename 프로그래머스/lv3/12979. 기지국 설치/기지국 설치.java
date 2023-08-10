class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        long start = 1;
        long end = 0;
        for(int station : stations){
            
            end = station - w-1;
            answer += Math.ceil((double)(end - start + 1) / (w*2+1));
            start = station + w+1;
        }
        end = n;
        answer += Math.ceil((double)(end - start+1) / (w*2+1));

        return answer;
    }
}