class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.num-x.num);
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair(nums[i],i));
        }
        int ans[] = new int[k];
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(k-->0){
            Pair p = pq.remove();
            map.put(p.index,p.num);
        }
        int ind = 0;
        Set<Integer> keys = map.keySet();
        for(int key : keys){
            ans[ind++] = map.get(key);
        }
        return ans;
    }
}
class Pair{
    int num;
    int index;
    Pair(int num,int index){
        this.num = num;
        this.index = index;
    }
}