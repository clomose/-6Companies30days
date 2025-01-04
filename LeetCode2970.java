class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(check(nums,i,j)){
                    count++;
                }
            }
        }
        return count;
    }
    boolean check(int []nums,int start,int end){
        int prev = 0;
        for(int i=0;i<nums.length;i++){
            if((i<start || i>end)){
                if(nums[i]>prev){
                    prev = nums[i];
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}