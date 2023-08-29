class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length -1;
        int ans = (end - start) * Math.min(height[start], height[end]);
        while(true){
            if(height[start] > height[end]){
                end--;
            }else{
                start++;
            }
            if(start == end) break;
            int tmp =  (end - start) * Math.min(height[start], height[end]);
            ans = Math.max(ans, tmp);
            
        }
        return ans;
    }
}