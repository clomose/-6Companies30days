class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int l = nums[0];
        int h = nums[nums.length-1];
        int ans = 0;
        while(l<=h){
            int mid = l+(h-l)/2;
            int m = sum(nums,mid);
            int left = sum(nums,mid-1);
            int right = sum(nums,mid+1);
            if(m<=left && m<=right){
                ans = m;
                break;
            }
            if(m>left && m<=right){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    int sum(int []nums,int x){
        int s = 0;
        for(int i:nums){
            if(i==x){
                continue;
            }
            if(i<x){
                s = s+(x-i);
            }else{
                s = s+(i-x);
            }
        }
        return s;
    }
}