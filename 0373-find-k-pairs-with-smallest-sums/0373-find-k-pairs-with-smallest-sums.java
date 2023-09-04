class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resV = new ArrayList<>(); // Result list to store the pairs
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
       
       // 1. nums1의 모든 값들과 nums2의 0번째 인덱스를 더한 값 모두 최소힙에 넣기
       for(int i=0; i < nums1.length && i < k; i++){
           // 1-1 . 1번째는 nums1의 값, 2번째는 순서쌍의 합(최소힙 Comparator에 사용), 3번째는 num2의 인덱스
           pq.add(new int[]{nums1[i], nums1[i] + nums2[0], 0});
       }

       List<List<Integer>> ans = new ArrayList<>();
       // 2. Heap에서 하나를 뽑아서 정답 리스트에 추가하고 그 다음으로 가능성 있는 수를 Heap에 넣기
       while(k-- > 0){
             if(pq.isEmpty()){
               return ans;
           }
           int[] cur = pq.poll();
           List<Integer> lst = new ArrayList<>();
           
           // 2-1. 최소값의 nums1, nums2값 넣기
           lst.add(cur[0]);
           lst.add(nums2[cur[2]]); 
           ans.add(lst);

           // 2-2 . 가능성 있는 수 heap에 넣기
           if(cur[2] + 1 < nums2.length){
            pq.add(new int[]{cur[0], cur[0]+nums2[cur[2]+1], cur[2]+1});
           }
         

       }
       return ans;


    }
}