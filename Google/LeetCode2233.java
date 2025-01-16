class Solution {
    public int maximumProduct(int[] nums, int k) {
        int mod = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.add(i);
        }
        while(k-->0){
            pq.add(pq.remove()+1);
        }
        long ans = 1;
        while(!pq.isEmpty()){
            ans = (ans * pq.remove())%mod;
        }
        return (int)ans;
    }
}