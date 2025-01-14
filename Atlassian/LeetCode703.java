class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int i : nums){
            pq.add(i);
            if(pq.size()>k){
                pq.remove();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size()>k){
            pq.remove();
        }
        return pq.peek();
    }
}
