class MedianFinder {

    private static PriorityQueue<Integer> maxHeap;
    private static PriorityQueue<Integer> minHeap; 
    public MedianFinder() {
        //Heap 초기화
        maxHeap = new PriorityQueue<>((a, b) -> b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {

        // 1. maxHeap과 minHeap에 번갈아가면서 숫자를 채운다
        if(maxHeap.size() == minHeap.size()){
maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        
        // 2. minHeap의 최솟값은 maxHeap의 최댓값보다 크거나 같아야한다
        if(maxHeap.isEmpty() || minHeap.isEmpty()) return;

        // 2-1. minHeap의 최솟값이 maxHeap의 최댓값보다 작으면 둘의 위치를 바꿔준다.
        while(maxHeap.peek() > minHeap.peek()){
            int tmp = minHeap.poll();
            minHeap.add(maxHeap.poll());
            maxHeap.add(tmp);
        }
    }
    
    public double findMedian() {
        // 3. maxHeap부터 채울 것이므로 maxHeap이 비어있다면 return null;
        if(maxHeap.isEmpty()) return 0.0;

        // 3-1. maxHeap과 minHeap의 사이즈가 같다면 각각의 최대 최소를 뽑아서 2로 나누기
        if(maxHeap.size() == minHeap.size())
        { 
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }// 3-2. maxHeap과 minHeap의 사이즈가 다르다면 maxHeap의 최댓값이 중앙값
        else{
            return (double) maxHeap.peek();

        }

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */