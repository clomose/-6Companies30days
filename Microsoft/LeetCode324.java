class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int arr[] = new int[nums.length];
        int h = n-1;
        int l = (n-1)/2;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i=i+2){
            arr[i] = nums[l];
            arr[i+1] = nums[h];
            h--;
            l--;
        }
        if(n%2==1){
            arr[n-1]=nums[0];
        }
        for(int i=0;i<n;i++){
            nums[i]=arr[i];
        }
    }
}