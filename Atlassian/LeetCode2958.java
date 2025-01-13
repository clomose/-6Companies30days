class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        int l = 0;
        for(int r=0;r<nums.length;r++){
            if(map.containsKey(nums[r]) && map.get(nums[r])==k){
                map.put(nums[r],map.get(nums[r])-1);
                while(l<r && nums[l]!=nums[r]){
                    map.put(nums[l],map.get(nums[l])-1);
                    l++;
                }
                l++;
            }
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            ans = Math.max(ans,(r-l+1));
        }
        return ans;
    }
}