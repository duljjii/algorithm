class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int val : nums){
            count[val]++;
        }
        int[] answer = new int[nums.length];
        int idx=0;
        int color = 0;
        for(int cnt : count){
            for(int i=0; i<cnt; i++){
                nums[idx++]=color;
            }
            color++;
        }
        

    }
}