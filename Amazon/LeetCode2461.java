class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        long ans = 0;
        long sum = 0;
        int l = 0;
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            int index = map.getOrDefault(n,-1);
            while(l<=index || (i-l+1)>k){
                sum-=nums[l];
                l++;
            }
            map.put(n,i);
            sum+=n;
            if((i-l+1)==k){
                ans = Math.max(ans,sum);
            }
        }
        return ans;
    }
}